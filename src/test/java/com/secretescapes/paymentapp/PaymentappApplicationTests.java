package com.secretescapes.paymentapp;

import com.secretescapes.paymentapp.controller.AccountController;
import com.secretescapes.paymentapp.service.EmailService;
import com.secretescapes.paymentapp.service.TransactionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class PaymentappApplicationTests {

    @Autowired
    AccountController accountController;

    @Autowired
    EmailService emailService;

    @Autowired
    TransactionService transactionService;

    Integer fromAccountNo = 1;
    Integer toAccountNo = 2;
    Integer accountId = 1;
    Integer amount = 20;
    int balance = 50;

    @Test
    @DisplayName("Find all the accounts in db")
    public void T1_findAllAccounts() {
        accountController.findAllAccounts();
    }

    @Test
    @DisplayName("Send an email to existing account")
    public void T2_sendEmail_Happy() {
        emailService.sendEmail(fromAccountNo, toAccountNo);
    }

    @Test
    @DisplayName("Try to send an email to nonexistent account")
    public void T2_sendEmail_Unhappy() {
        fromAccountNo = 10;
        try {
            emailService.sendEmail(fromAccountNo, toAccountNo);
        } catch (Exception e) {
            assert true;
            return;
        }
        assert false;
    }

    @Test
    @DisplayName("Find Transactions by a specific Account Id")
    public void T3_findTransactionsByAccount_Happy() {
        transactionService.findTransactionsByAccount(accountId);
    }

    @Test
    @DisplayName("Make payment with valid amount")
    public void T4_makePayment_Happy() throws Exception {
        transactionService.makePayment(toAccountNo, fromAccountNo, amount);
    }

    @Test
    @DisplayName("Try to make payment with invalid amount")
    public void T4_makePayment_Unhappy_1() {
        amount = null;
        try {
            transactionService.makePayment(toAccountNo, fromAccountNo, amount);
        } catch (Exception e) {
            assert true;
            return;
        }
        assert false;
    }

    @Test
    @DisplayName("Try to make payment with nonexistent account")
    public void T4_makePayment_Unhappy_2() {
        toAccountNo = 10;
        try {
            transactionService.makePayment(toAccountNo, fromAccountNo, amount);
        } catch (Exception e) {
            assert true;
            return;
        }
        assert false;
    }

    @Test
    @DisplayName("Save transaction with valid payment")
    public void T5_saveTransaction_Happy() {
        transactionService.saveTransaction(toAccountNo, fromAccountNo, amount);
    }

    @Test
    @DisplayName("Try to save transaction with invalid payment")
    public void T5_saveTransaction_Unhappy() {
        amount = null;
        try {
            transactionService.saveTransaction(toAccountNo, fromAccountNo, amount);
        } catch (Exception e) {
            assert true;
            return;
        }
        assert false;
    }

    @Test
    @DisplayName("Balance is more than amount, payment is valid")
    public void T6_validatePayment_Happy() throws Exception {
        int amount = 20;
        int balance = 50;
        transactionService.validatePayment(amount, balance);
    }

    @Test
    @DisplayName("Amount is more than balance, payment is not valid")
    public void T7_validatePayment_Unhappy() {
        int amount = 50;
        int balance = 20;
        try {
            transactionService.validatePayment(amount, balance);
        } catch (Exception e) {
            assert true;
            return;
        }
        assert false;
    }
}
