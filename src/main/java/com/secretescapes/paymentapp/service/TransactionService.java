package com.secretescapes.paymentapp.service;

import com.secretescapes.paymentapp.model.Account;
import com.secretescapes.paymentapp.model.Transaction;
import com.secretescapes.paymentapp.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final static Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    EmailService emailService;

    /* findTransactionsByAccount method
     * returns list of transactions carried by specific account
     */
    public List<Transaction> findTransactionsByAccount(int accountId) {
        List<Transaction> transactionsList = transactionRepository.getTransactionByAccount(accountId);
        return transactionsList;
    }

    /* makePayment method carries out the payment process
     * returns the result of payment as string
     */
    public String makePayment(int inputToAccount, int inputFromAccount, int inputAmount) throws Exception {

        Optional<Account> fromAccountId = accountService.findAccountById(inputFromAccount);
        Optional<Account> toAccountId = accountService.findAccountById(inputToAccount);

        if (validatePayment(inputAmount, fromAccountId.get().getBalance())) {
            // performs the calculation of new balances of both sender and receiver
            Account toAccount = toAccountId.get();
            toAccount.setBalance(toAccount.getBalance() + (inputAmount));
            Account fromAccount = fromAccountId.get();
            fromAccount.setBalance(fromAccount.getBalance() - (inputAmount));

            accountService.saveAccount(fromAccount);
            accountService.saveAccount(toAccount);
            emailService.sendEmail(inputFromAccount, inputToAccount);
        }
        String transactionMessage = saveTransaction(inputToAccount, inputFromAccount, inputAmount);
        LOGGER.info("Payment successful!");
        return transactionMessage;
    }

    /* saveTransaction method saves the transaction and associates it to both sender and receiver
     * returns the result of transaction as string
     */
    public String saveTransaction(int toAccount, int fromAccount, int amount) {
        String transactionMessage = "";
        try {
            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setFromAccount(fromAccount);
            transaction.setToAccount(toAccount);
            Transaction savedTransaction = transactionRepository.save(transaction);
            transactionMessage = "Transaction is saved";
        } catch (Exception e) {
            LOGGER.error("Thrown exception: " + e);
        }
        return transactionMessage;
    }

    /* validatePayment method controls if the payment is valid or not
     * returns true if the payment is valid otherwise it will throw an exception
     */
    public boolean validatePayment(Integer amount, Integer balance) throws Exception {
        // if the amount and/or balance is null, payment won't be valid
        // payment amount should be less than the balance of the sender
        if (amount == null || balance == null || amount > balance) {
            throw new Exception("Invalid amount, payment failed");
        }
        LOGGER.info("Payment is valid");
        return true;
    }

}
