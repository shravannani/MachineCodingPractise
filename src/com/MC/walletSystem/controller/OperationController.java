package com.MC.walletSystem.controller;

import java.util.Scanner;

public class OperationController {

    private final String CREATE = "CreateWallet";
    private final String OVERVIEW = "Overview";
    private final String TRANSFER = "TransferMoney";
    private final String STATEMENT = "Statement";
    private final String OFFER2 = "Offer2";

    WalletOperations walletOperations = new WalletOperations();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            switch (input.split(" ")[0].trim()) {
                case CREATE: {
                    String[] inpArray = input.trim().split(" ");
                    walletOperations.createWallet(inpArray[1], Double.parseDouble(inpArray[2]));
                    break;
                }
                case TRANSFER: {
                    String[] inpArray = input.trim().split(" ");
                    walletOperations.transferMoney(inpArray[1], inpArray[2], Double.parseDouble(inpArray[3]));
                    break;
                }
                case STATEMENT: {
                    String[] inpArray = input.trim().split(" ");
                    walletOperations.statement(inpArray[1]);
                    break;
                }
                case OVERVIEW: {
                    walletOperations.overView();
                    break;
                }
                case OFFER2: {
                    walletOperations.offer2();
                    break;
                }
            }
        }
    }

}
