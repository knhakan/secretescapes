package com.secretescapes.paymentapp.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    @Column
    private String name;
    @Column
    private int balance;
    @Column
    private String emailaddress;

    public Account() {
    }

    public Account(int accountId, String name, int balance, String emailaddress) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
        this.emailaddress = emailaddress;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", emailaddress='" + emailaddress + '\'' +
                '}';
    }
}
