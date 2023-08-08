package task2;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class TransactionHistory {
	
    private ArrayList<Transaction> transactions;

    public TransactionHistory() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}	    
	    
