package com.MC.walletSystem.models;

import java.util.List;

public class AccountHolders {

    List<AccountHolder> accountHolders;

    public AccountHolders(List<AccountHolder> accountHolders) {
        this.accountHolders = accountHolders;
    }

    public List<AccountHolder> getAccountHolders() {
        return accountHolders;
    }

    public void setAccountHolders(List<AccountHolder> accountHolders) {
        this.accountHolders = accountHolders;
    }
}
