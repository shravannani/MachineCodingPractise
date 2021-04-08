package com.MC.walletSystem;

import com.MC.walletSystem.controller.OperationController;

public class Main {

    public static void main(String[] args) {
        OperationController operationController = new OperationController();
        operationController.start();
    }
}
