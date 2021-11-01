package com.secretescapes.paymentapp.service;

import com.secretescapes.paymentapp.model.Account;
import com.secretescapes.paymentapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    /* findAllAccounts method returns list of all accounts in db
     */
    public List<Account> findAllAccounts() {
        List<Account> accountsList = accountRepository.getAllAccounts();
        return accountsList;
    }

    /* findAccountById method returns single Account by AccountId
     * it is Optional since the result may be null
     */
    public Optional<Account> findAccountById(int accountId) {
        return accountRepository.findById(accountId);
    }

    /* findEmailByAccountId method returns the email of the user's account by AccountId
     */
    public String findEmailByAccountId(Integer accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        return account.get().getEmailaddress();
    }

    /* saveAccount method saves account
     * returns Account object
     */
    public Account saveAccount(Account accountToSave) {
        return accountRepository.save(accountToSave);
    }
}
