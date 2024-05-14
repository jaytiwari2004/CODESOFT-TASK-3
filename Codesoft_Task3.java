import java.util.Scanner;

// Class to represent the ATM machine
class ATM {
    private BankAccount userAccount;
    
    // Constructor to initialize the ATM with a user's bank account
    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    // Method to withdraw money from the ATM
    public void withdraw(double amount) {
        if (userAccount.getBalance() >= amount) {
            userAccount.withdraw(amount);
            System.out.println(" Successful withdrawal . Remaining balance: " + userAccount.getBalance());
        } else {
            System.out.println(" Balance is insufficient. Please try again.");
        }
    }
    
    // Method to deposit money into the ATM
    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println(" Successful deposite. New balance: " + userAccount.getBalance());
    }
    
    // Method to check the balance in the ATM
    public void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }
}

// Class to represent the user's bank account
class BankAccount {
    private double balance;
    
    // Constructor to initialize the bank account with an initial balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    // Method to withdraw money from the bank account
    public void withdraw(double amount) {
        balance -= amount;
    }
    
    // Method to deposit money into the bank account
    public void deposit(double amount) {
        balance += amount;
    }
    
    // Method to get the current balance of the bank account
    public double getBalance() {
        return balance;
    }
}

public class Codesoft_Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize the user's bank account with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000);
        
        // Initialize the ATM with the user's bank account
        ATM atm = new ATM(userAccount);
        
        // User interface for the ATM
        while (true) {
            System.out.println("\nWelcome to the ATM.");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print(" Please enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Please enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you. see you soon!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}