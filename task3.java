// Importing the scanner class to enable I/O operations!
import java.util.Scanner;

public class task3 {
    // This class represents an Employee and their details.
    public static class Employee {
        // Attributes of an Employee: first name, last name, monthly salary, and experience.
        public String firstname;
        public String lastname;
        double monthlysalary;
        int experience;

        // Method to display details of an Employee.
        public void displayDetails() {
            // We print out the employee's name, monthly salary, and experience.
            System.out.printf("%s %s has a monthly salary of Rs. %.2f with an experience of %d years!\n", firstname, lastname, monthlysalary, experience);
        }

        // Method to calculate yearly salary of an Employee.
        public double calculateYearlySalary () {
            // Yearly salary is simply monthly salary multiplied by 12.
            return monthlysalary * 12;
        }

        // Method to update an Employee's salary based on experience.
        public void updateSalary () {
            // We calculate appraisal based on a 10% increment per year of experience.
            double appraisal = (monthlysalary * 0.1) * experience;
            // Then we add the appraisal to the monthly salary.
            monthlysalary += appraisal;
        }
    }

    // This class is for testing the Employee class.
    public static class EmployeeTest {
        // Method to test the Employee class.
        public static void test (String args[]) {
            // We start by getting input from the user.
            Scanner input = new Scanner(System.in);
            // Let's create two Employee objects to work with.
            Employee employee1 = new Employee();
            Employee employee2 = new Employee();
            
            // Now, we ask for details of the first employee.
            System.out.println("Please enter first name of the first employee: ");
            employee1.firstname = input.next();
            System.out.println("Please enter last name of the first employee: ");
            employee1.lastname = input.next();
            System.out.println("Please enter monthly salary of the first employee: ");
            employee1.monthlysalary = input.nextDouble();
            System.out.println("Please enter experience of the first employee: ");
            employee1.experience = input.nextInt();
            
            // Then, we ask for details of the second employee.
            System.out.println("Please enter first name of the second employee: ");
            employee2.firstname = input.next();
            System.out.println("Please enter last name of the second employee: ");
            employee2.lastname = input.next();
            System.out.println("Please enter monthly salary of the second employee: ");
            employee2.monthlysalary = input.nextDouble();
            System.out.println("Please enter experience of the second employee: ");
            employee2.experience = input.nextInt();
            
            // Now, let's display the yearly salary before and after updating.
            System.out.println("\nBefore updating salaries: \n");
            System.out.printf("Employee 1 Yearly salary: %.2f\nEmployee 2 Yearly salary: %.2f",employee1.calculateYearlySalary(),employee2.calculateYearlySalary());
            
            // Let's update the salaries of both employees.
            employee1.updateSalary();
            employee2.updateSalary();
            
            // And finally, let's display the updated yearly salaries.
            System.out.println("\nAfter updating salaries: \n");
            System.out.printf("Employee 1 Yearly salary: %.2f\nEmployee 2 Yearly salary: %.2f",employee1.calculateYearlySalary(),employee2.calculateYearlySalary());

            // Don't forget to close the input scanner to avoid memory leaks.
            input.close();
        }
    }

    // This is our main method where everything starts.
    public static void main(String[] args) {
        // We start testing the Employee class by calling the test method from EmployeeTest class.
        EmployeeTest.test(args);
    }
}
