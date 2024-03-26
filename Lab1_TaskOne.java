import java.util.Scanner;

// Class definition for the main task
public class Lab1_TaskOne {

    // Method to round a floating-point number to two decimal places
    public static float round(float F) {
        // Multiply by 100, add 0.5 for rounding, cast to int to truncate decimal part,
        // then divide by 100 to restore two decimal places
        float value = (int) (F * 100 + 0.5);
        return value / 100;
    }

    // Method to calculate gravitational force between two objects
    public static float force(double m1, double m2, double r) {
        // Gravitational constant (G)
        float G = (float) (6.67 / 1e11);
        
        // Calculate gravitational force using Newton's law of gravitation
        float F = (G * (float) m1 * (float) m2) / ((float) r * (float) r);

        // Round the gravitational force to two decimal places using the round method
        return round(F);
    }

    // Main method for user input and program execution
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variables to store masses and distance
        float m1, m2, r;

        try {
            // Get the mass of the first object from the user
            System.out.print("Enter the mass of the first object (in kg): ");
            m1 = input.nextFloat();

            // Get the mass of the second object from the user
            System.out.print("Enter the mass of the second object (in kg): ");
            m2 = input.nextFloat();

            // Get the distance between the two objects from the user
            System.out.print("Enter the distance between the two objects (in meters): ");
            r = input.nextFloat();

        } finally {
            // Close the Scanner to avoid resource leaks
            input.close();
        }

        // Calculate and display the gravitational force using the force method
        System.out.println("The Gravitational Force is: " + force(m1, m2, r) + " N");
    }
}


