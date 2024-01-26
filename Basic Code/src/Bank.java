import java.util.Scanner;

public class Bank {
    private int accountNumber;
    private double balance;

    public Bank(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public void searchByAccountNumber(int searchAccountNumber) {
        if (accountNumber == searchAccountNumber) {
            displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        Bank account = new Bank(accountNumber, initialBalance);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display all account details");
            System.out.println("2. Search by account number");
            System.out.println("3. Deposit the amount");
            System.out.println("4. Withdraw the amount");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.displayAccountDetails();
                    break;
                case 2:
                    System.out.print("Enter account number to search: ");
                    int searchAccountNumber = scanner.nextInt();
                    account.searchByAccountNumber(searchAccountNumber);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 5:
                    System.out.println("Exiting the bank application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 5);

//        scanner.close();
    }
}
