package com.MC.walletSystem.models;

import java.util.List;

public class Wallet {

    List<Transaction> transactions;
    double balance;

    public Wallet(List<Transaction> transactions, double balance) {
        this.transactions = transactions;
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void displayTransactions() {
        for (Transaction transaction : this.getTransactions()) {
            transaction.displayTransaction();
        }
    }
}
