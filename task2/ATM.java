package task2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class ATM {
	private User currentUser;

    public boolean login(String userId, String userPin) {
        // Replace this with your authentication logic
        // For simplicity, we use a hardcoded user
        if (userId.equals("Atm123") && userPin.equals("1234")) {
            currentUser = new User(userId, userPin, 10000.0);
            return true;
        }
        return false;
    }

    public void displayOptions() {
        System.out.println("\nATM Options:");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("0. Exit");
    }

    public void performOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                displayTransactionHistory();
                break;
            case 2:
                System.out.print("Enter the amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                boolean successWithdraw = currentUser.withdraw(withdrawAmount);
                if (successWithdraw) {
                    System.out.println("Withdrawal successful. Current balance: " + currentUser.getAccountBalance());
                } else {
                    System.out.println("Insufficient funds. Current balance: " + currentUser.getAccountBalance());
                }
                break;
            case 3:
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                currentUser.deposit(depositAmount);
                System.out.println("Deposit successful. Current balance: " + currentUser.getAccountBalance());
                break;
            case 4:
                System.out.print("Enter the recipient's user ID: ");
                String recipientId = scanner.next();
                System.out.print("Enter the amount to transfer: ");
                double transferAmount = scanner.nextDouble();
                User recipient = getUserById(recipientId);
                if (recipient != null) {
                    boolean successTransfer = currentUser.transfer(recipient, transferAmount);
                    if (successTransfer) {
                        System.out.println("Transfer successful. Current balance: " + currentUser.getAccountBalance());
                    } else {
                        System.out.println("Insufficient funds. Current balance: " + currentUser.getAccountBalance());
                    }
                } else {
                    System.out.println("Recipient not found.");
                }
                break;
            case 0:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void displayTransactionHistory() {
        ArrayList<Transaction> transactions = currentUser.getTransactionHistory().getTransactions();
        System.out.println("\nTransaction History:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getType() + " - Amount: " + transaction.getAmount() + " - Timestamp: " + transaction.getTimestamp());
        }
    }

    private User getUserById(String userId) {
        // Replace this with your user retrieval logic
        // For simplicity, we use a hardcoded user
        if (userId.equals("Atm123")) {
            return new User("Atm123", "1234", 500.0);
        }
        return null;
    }
}
