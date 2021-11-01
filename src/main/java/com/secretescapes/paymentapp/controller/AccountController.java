package com.secretescapes.paymentapp.controller;


import com.secretescapes.paymentapp.model.Account;
import com.secretescapes.paymentapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /* findAllAccounts method
     * returns all accounts as account object
     */
    @GetMapping("/account")
    public ResponseEntity<List<Account>> findAllAccounts() {
        List<Account> accounts = accountService.findAllAccounts();
        return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
    }

}
