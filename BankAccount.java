# Auto detect text files and perform LF normalization
* text=auto
import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize account with a balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to check the current balance
    public double checkBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew ₹" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Unable to withdraw ₹" + amount);
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;

    // Constructor to link the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM menu and handle user interactions
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Welcome to the ATM ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Check Balance
                    System.out.println("Your current balance is ₹" + account.checkBalance());
                    break;
                
                case 2: // Deposit Money
                    System.out.print("Enter the amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                
                case 3: // Withdraw Money
                    System.out.print("Enter the amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                
                case 4: // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                
                default:
                    System.out.println("Invalid choice. Please select an option from 1 to 4.");
            }
        }

        scanner.close();
    }
}

// Main class to run the ATM system
public class ATMSystem {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount account = new BankAccount(5000.0);

        // Create an ATM linked to the bank account
        ATM atm = new ATM(account);

        // Show the ATM menu
        atm.showMenu();
    }
}