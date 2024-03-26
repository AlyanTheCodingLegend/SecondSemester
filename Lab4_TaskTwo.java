// This Java program includes a class named Lab4_TaskTwo. 
// Inside this class, there is a nested class called BankAccount, which represents bank account objects.

// The BankAccount class has private attributes such as accountNumber, accountHolderName, balance, and accountType, along with constructors and methods to access and modify these attributes.

// Importing necessary packages.
import java.security.SecureRandom; // This imports the SecureRandom class for generating random numbers.
import java.util.Scanner; // This imports the Scanner class for taking user input.

public class Lab4_TaskTwo { // This is the main class.

    // This is a nested class called BankAccount.
    static class BankAccount {
        private String accountNumber; // This stores the account number.
        private String accountHolderName; // This stores the name of the account holder.
        private double balance; // This stores the balance of the account.
        private String accountType; // This stores the type of the account.

        // Constructor method for creating a BankAccount object with holder name, initial balance, and account type parameters.
        public BankAccount (String holderName, double initialBalance, String typeAccount) {
            SecureRandom rand = new SecureRandom(); // Creates a SecureRandom object for generating random numbers.
            accountNumber = String.valueOf(rand.nextInt(1000000)); // Generates a random account number.
            accountHolderName = holderName; // Sets the account holder's name.
            balance = initialBalance; // Sets the initial balance.
            accountType = typeAccount; // Sets the type of account.
        }

        // Getter method to retrieve the account number.
        public String getAccNumber() {
            return accountNumber; // Returns the account number.
        }

        // Getter method to retrieve the account holder's name.
        public String getAccName() {
            return accountHolderName; // Returns the account holder's name.
        }

        // Setter method to update the account holder's name.
        public void setAccName(String name) {
            accountHolderName = name; // Sets the account holder's name.
        }

        // Getter method to retrieve the balance of the account.
        public double getBalance() {
            return balance; // Returns the balance of the account.
        }

        // Setter method to update the balance of the account.
        public void setBalance(double balance) {
            this.balance = balance; // Sets the balance of the account.
        }

        // Getter method to retrieve the type of the account.
        public String getAccType() {
            return accountType; // Returns the type of the account.
        }

        // Setter method to update the type of the account.
        public void setAccType(String type) {
            accountType = type; // Sets the type of the account.
        }

        // Method to display details of the bank account.
        public void displayDetails() {
            // Prints the account number, account holder's name, balance, and account type.
            System.out.printf("Account Number: %s\nAccount Name: %s\nBalance: $ %.2f\nAccount Type: %s\n", accountNumber, accountHolderName, balance, accountType);
        }

        // Method to deposit money into the account.
        public void depositMoney(double money) {
            balance += money; // Increases the balance by the deposited amount.
            System.out.println("Deposited successfully!\n"); // Prints a success message.
        }

        // Method to withdraw money from the account.
        public void withdrawMoney(double money) {
            if (balance >= money) { // Checks if the balance is sufficient for withdrawal.
                balance -= money; // Decreases the balance by the withdrawn amount.
                System.out.println("Withdrawn successfully!\n"); // Prints a success message.
            } else {
                System.out.println("Insufficient funds!\n"); // Prints a message for insufficient funds.
            }
        }
    }

    // This is the main method where the program execution starts.
    public static void main(String args[]) {
        // Creating an instance of the BankAccount class and initializing it with specific values.
        BankAccount account1 = new BankAccount("Alyan Ahmed", 50000, "Current"); // Creates a bank account for Alyan Ahmed.
        account1.displayDetails(); // Displays details of account1.

        // Creating a Scanner object to take user input.
        Scanner input = new Scanner(System.in); // Creates a Scanner object named input.

        // Prompting the user to enter the amount to deposit into the account.
        System.out.println("\nHow much money do you want to deposit into your account?");
        double depmoney = input.nextDouble(); // Takes user input for deposit amount.
        account1.depositMoney(depmoney); // Deposits the entered amount into account1.
        account1.displayDetails(); // Displays updated details of account1.

        // Prompting the user to enter the amount to withdraw from the account.
        System.out.println("\nHow much money do you want to withdraw from your account?");
        double withmoney = input.nextDouble(); // Takes user input for withdrawal amount.
        account1.withdrawMoney(withmoney); // Withdraws the entered amount from account1.
        account1.displayDetails(); // Displays updated details of account1.
        
        System.out.println("\n");
        
        // Creating another instance of the BankAccount class and initializing it with specific values.
        BankAccount account2 = new BankAccount("John Stones", 12500, "Savings"); // Creates a bank account for John Stones.
        account2.displayDetails(); // Displays details of account2.

        // Prompting the user to enter the amount to deposit into the account.
        System.out.println("\nHow much money do you want to deposit into your account?");
        double depmoney2 = input.nextDouble(); // Takes user input for deposit amount.
        account2.depositMoney(depmoney2); // Deposits the entered amount into account2.
        account2.displayDetails(); // Displays updated details of account2.

        // Prompting the user to enter the amount to withdraw from the account.
        System.out.println("\nHow much money do you want to withdraw from your account?");
        double withmoney2 = input.nextDouble(); // Takes user input for withdrawal amount.
        account2.withdrawMoney(withmoney2); // Withdraws the entered amount from account2.
        account2.displayDetails(); // Displays updated details of account2.

        input.close(); // Closes the Scanner object to release resources.
    }
}
