package com.MC.walletSystem.models;

public class Transaction {

    String senderOrReceiverName;
    double prevAmount;
    double newAmount;
    String type;
    public Transaction(double prevAmount, double newAmount, String type, String senderOrReceiverName) {
        this.prevAmount = prevAmount;
        this.newAmount = newAmount;
        this.type = type;
        this.senderOrReceiverName = senderOrReceiverName;
    }

    public String getSenderOrReceiverName() {
        return senderOrReceiverName;
    }

    public void setSenderOrReceiverName(String senderOrReceiverName) {
        this.senderOrReceiverName = senderOrReceiverName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrevAmount() {
        return prevAmount;
    }

    public void setPrevAmount(double prevAmount) {
        this.prevAmount = prevAmount;
    }

    public double getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(double newAmount) {
        this.newAmount = newAmount;
    }

    public void displayTransaction() {
        System.out.println(
            this.getSenderOrReceiverName() + " " + this.getType() + " " + Math.abs(this.getNewAmount() - this.getPrevAmount()));
    }
}
