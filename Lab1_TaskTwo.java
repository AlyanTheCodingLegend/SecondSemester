import java.util.Scanner;

// Class definition for the main task
public class Lab1_TaskTwo {

    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Get the first floating-point number from the user
        System.out.print("Enter the first number: ");
        double number1 = input.nextFloat();

        // Get the second floating-point number from the user
        System.out.print("Enter the second number: ");
        double number2 = input.nextFloat();

        // Calculate sum, difference, and average
        double sum = number1 + number2;
        double difference = number1 - number2;
        double average = (number1 + number2) / 2;

        // Display the results using printf
        System.out.printf("Sum: %.2f%n", sum);
        System.out.printf("Difference: %.2f%n", difference);
        System.out.printf("Average: %.2f%n", average);

        // Close the scanner
        input.close();
    }
}

