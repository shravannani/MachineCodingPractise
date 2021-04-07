package com.MC.walletSystem.controller;

import com.MC.walletSystem.models.AccountHolder;
import com.MC.walletSystem.models.AccountHolders;
import com.MC.walletSystem.models.Transaction;
import com.MC.walletSystem.models.TransactionType;
import com.MC.walletSystem.models.Wallet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.TreeMap;

public class WalletOperations {

    AccountHolders accountHolders;
    TreeMap<Integer, List<String>> topTransactions = new TreeMap<>();

    public WalletOperations() {
        accountHolders = new AccountHolders(new ArrayList<>());
    }

    public void createWallet(String accountHolder, double amount) {
        accountHolders.getAccountHolders().add(new AccountHolder(accountHolder, new Wallet(new ArrayList<>(), amount)));
    }

    public void transferMoney(String sender, String receiver, double amount) {
        Optional<AccountHolder> senderDetails = findAccountHolderDataByName(sender);
        Optional<AccountHolder> receiverDetails = findAccountHolderDataByName(receiver);

        updateBalance(-1 * amount, receiver, senderDetails.get());
        updateBalance(amount, sender, receiverDetails.get());

        redeemOffer1IfEligible(senderDetails.get(), receiverDetails.get());
    }

    public void redeemOffer1IfEligible(AccountHolder sender, AccountHolder receiver) {
        if (isEligibleForOffer1(sender, receiver)) {
            updateBalance(10, "Offer1", sender);
            updateBalance(10, "Offer1", receiver);
        }
    }

    public boolean isEligibleForOffer1(AccountHolder sender, AccountHolder receiver) {
        return sender.getWallet().getBalance() == receiver.getWallet().getBalance();
    }

    public void updateBalance(double amount, String senderOrReceiverName, AccountHolder accountHolder) {
        double currentBalance = accountHolder.getWallet().getBalance();
        String type = amount > 0 ? TransactionType.CREDIT.toString() : TransactionType.DEBIT.toString();
        accountHolder.getWallet().getTransactions().add(new Transaction(currentBalance, Math.abs(currentBalance + amount),
            type, senderOrReceiverName));
        accountHolder.getWallet().setBalance(Math.abs(currentBalance + amount));
    }

    public Optional<AccountHolder> findAccountHolderDataByName(String name) {
        for (AccountHolder accountHolder : accountHolders.getAccountHolders()) {
            if (accountHolder.getName().equals(name)) {
                return Optional.of(accountHolder);
            }
        }

        return Optional.empty();
    }

    public void statement(String name) {
        Optional<AccountHolder> accountHolderDetails = findAccountHolderDataByName(name);
        accountHolderDetails.get().getWallet().displayTransactions();
    }

//    public void displayBalance(AccountHolder accountHolder){
//        System.out.println(accountHolder.getName() + " " + accountHolder.getWallet().getBalance());
//    }

    public void overView() {
        for (AccountHolder accountHolder : accountHolders.getAccountHolders()) {
            accountHolder.displayBalance();
        }
    }

    public void offer2() {
        for (AccountHolder accountHolder : accountHolders.getAccountHolders()) {
            int noOfTransactions = accountHolder.getWallet().getTransactions().size();
            if (topTransactions.containsKey(noOfTransactions)) {
                topTransactions.get(noOfTransactions).add(accountHolder.getName());
                topTransactions.put(noOfTransactions, topTransactions.get(noOfTransactions));
            } else {
                List<String> names = new ArrayList<>();
                names.add(accountHolder.getName());
                topTransactions.put(noOfTransactions, names);
            }
        }

        processTop3();
    }

    public void processTop3() {
        List<Integer> offer2List = List.of(10, 5, 2);
        NavigableSet<Integer> keys = topTransactions.descendingKeySet();
        List<String> topNames = new ArrayList<>();

        for (int key : keys) {
            if (topNames.size() == 3) {
                break;
            }

            int remaining = 3 - topNames.size();

            List<String> values = topTransactions.get(key);
            Collections.sort(values);
            if (values.size() < remaining) {
                topNames.addAll(values);
            } else {
                for (int i = 0; i < remaining; i++) {
                    topNames.add(values.get(i));
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            Optional<AccountHolder> accountHolder = findAccountHolderDataByName(topNames.get(i));
            updateBalance(offer2List.get(i), "Offer2", accountHolder.get());
        }
    }
}
