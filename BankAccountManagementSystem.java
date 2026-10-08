import java.util.Scanner;

class  BankAccount{
    // Data members
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Parameterized constructor to initialize account details
    public  BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Error: Deposit amount must be greater than zero!");
        }
    }

    // Method to withdraw money if sufficient balance is available
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Error: Insufficient balance for this withdrawal!");
        } else {
            System.out.println("Error: Withdrawal amount must be greater than zero!");
        }
    }

    // Method to return the current balance
    public double checkBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccount() {
        System.out.println("-----------------------------------");
        System.out.println("Account Number  : " + accountNumber);
        System.out.println("Account Holder  : " + accountHolderName);
        System.out.println("Current Balance : $" + balance);
        System.out.println("-----------------------------------");
    }
}

public class  BankAccountManagementSystem {

    // Separate method to handle the deposit operation
    public static void executeDeposit(BankAccount account, Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    // Separate method to handle the withdrawal operation
    public static void executeWithdrawal(BankAccount account, Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading account details from the user
        System.out.println("=== Create Bank Account ===");
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accHolder = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        // Creating object using the parameterized constructor
        BankAccount myAccount = new BankAccount(accNumber, accHolder, initialBalance);

        // Display initial status
        System.out.println("\nInitial Account Details:");
        myAccount.displayAccount();

        // Perform one deposit operation using a separate method
        System.out.println("\n--- Deposit Transaction ---");
        executeDeposit(myAccount, scanner);

        // Perform one withdrawal operation using a separate method
        System.out.println("\n--- Withdrawal Transaction ---");
        executeWithdrawal(myAccount, scanner);

        // Display final account details
        System.out.println("\nFinal Account Details:");
        myAccount.displayAccount();

        scanner.close();
    }
}
