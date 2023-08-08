package task2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class ATMInterface {
	public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your user ID: ");
        String userId = scanner.next();
        System.out.print("Enter your user PIN: ");
        String userPin = scanner.next();

        boolean loggedIn = atm.login(userId, userPin);

        if (loggedIn) {
            System.out.println("Login successful. Welcome, " + userId + "!");
            int option;
            while (true) {
                atm.displayOptions();
                System.out.print("Enter option: ");
                option = scanner.nextInt();

                if (option == 0) {
                    break;
                }

                atm.performOption(option);
            }
        } else {
            System.out.println("Login failed. Invalid user ID or PIN.");
        }
    }
	
}
