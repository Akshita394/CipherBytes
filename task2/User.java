package task2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class User {
	private String userId;
    private String userPin;
    private double accountBalance;
    private TransactionHistory transactionHistory;

    public User(String userId, String userPin, double initialBalance) {
        this.userId = userId;
        this.userPin = userPin;
        this.accountBalance = initialBalance;
        this.transactionHistory = new TransactionHistory();
    }

    public String getUserId() {
        return userId;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        accountBalance += amount;
        transactionHistory.addTransaction(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            transactionHistory.addTransaction(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public boolean transfer(User recipient, double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            recipient.deposit(amount);
            transactionHistory.addTransaction(new Transaction("Transfer to " + recipient.getUserId(), amount));
            recipient.getTransactionHistory().addTransaction(new Transaction("Transfer from " + this.getUserId(), amount));
            return true;
        }
        return false;
    }
}
