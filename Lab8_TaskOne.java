// Importing important packages to enable I/O operations and ArrayList usage
import java.util.ArrayList;
import java.util.Scanner;

// Defining the parent class of Employee with common attributes
class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void printDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
    }

    public double getSalary() {
        return 0.0;
    }
}

// Inheriting from Employee class
class SalariedEmployee extends Employee {
    private double salary;

    public SalariedEmployee(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Salary: " + salary);
    }

    @Override
    public double getSalary() {
        return salary;
    }
}

// Inheriting from Employee class
class CommissionedEmployee extends Employee {
    private double salary;
    private double commissionRate;

    public CommissionedEmployee(String name, int id, double salary, double commissionRate) {
        super(name, id);
        this.commissionRate = commissionRate;
        this.salary=salary;
    }

    @Override
    public double getSalary() {
        return ((1+commissionRate)*salary);
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Salary: " + salary);
        System.out.println("Commission Rate: " + commissionRate);
    }
}

// Inheriting from Employee class
class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id); 
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
    }
}

// Defining an Invoice class
class Invoice {
    private String itemName;
    private int quantity;
    private double pricePerItem;

    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public double getTotalAmount() {
        return quantity * pricePerItem;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return pricePerItem;
    }
}

// Testing the classes above using a public class with a main function
public class Lab8_TaskOne {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new SalariedEmployee("John", 1001, 5000)); // Salaried Employee
        employees.add(new CommissionedEmployee("Alice", 1002, 3000, 0.1)); // Commissioned Employee
        employees.add(new HourlyEmployee("Bob", 1003, 15, 40)); // Hourly Employee

        double totalSalary = 0;

        System.out.println("Enter details for item purchases:");
        ArrayList<Invoice> invoices = new ArrayList<>();
        while (true) {
            System.out.print("Item name (type 'done' to finish): ");
            String itemName = input.nextLine();
            if (itemName.equals("done")) {
                break;
            }
            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(input.nextLine());
            System.out.print("Price per item: ");
            double pricePerItem = Double.parseDouble(input.nextLine());

            invoices.add(new Invoice(itemName, quantity, pricePerItem));
        }

        System.out.println("\nEmployee Details:");
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
            employee.printDetails();
            System.out.println();
        }

        System.out.println("\nTotal Salary: " + totalSalary);

        double totalExpenses = totalSalary;
        System.out.println("\nInvoice Details:");
        for (Invoice invoice : invoices) {
            totalExpenses += invoice.getTotalAmount();
            System.out.println("Item: " + invoice.getItemName());
            System.out.println("Quantity: " + invoice.getQuantity());
            System.out.println("Price per item: " + invoice.getPrice());
            System.out.println("Total Amount: " + invoice.getTotalAmount());
            System.out.println();
        }

        System.out.println("\nTotal Expenses (including salaries and purchases): " + totalExpenses);

        input.close();
    }
}
