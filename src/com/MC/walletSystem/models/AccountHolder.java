package com.MC.walletSystem.models;

public class AccountHolder {

    int id;
    String name;
    Wallet wallet;

    public AccountHolder(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void displayBalance() {
        System.out.println(getName() + " " + getWallet().getBalance());
    }
}
