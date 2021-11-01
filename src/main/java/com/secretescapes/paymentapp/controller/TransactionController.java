package com.secretescapes.paymentapp.controller;

import com.secretescapes.paymentapp.model.Transaction;
import com.secretescapes.paymentapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    /* findTransactionsByAccount method
     * returns Transaction objects by Account Id
     */
    @GetMapping("/transactions/{accountId}")
    public ResponseEntity<List<Transaction>> findTransactionsByAccount(@PathVariable int accountId) {
        List<Transaction> transactions = transactionService.findTransactionsByAccount(accountId);
        return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
    }

    /* makePayment method, carries out the payment process
     * returns the message coming from TransactionService
     */
    @PostMapping(value = "/pay", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity makePayment(@RequestBody Transaction transaction) throws Exception {
        int amount = transaction.getAmount();
        final String transactionMessage = transactionService.makePayment(transaction.getToAccount(), transaction.getFromAccount(), amount);
        return new ResponseEntity<>(transactionMessage, HttpStatus.OK);
    }


}
