// Importing the scanner class to enable I/O operations!
import java.util.Scanner;

public class task2 {
    // Inside this Invoice class, we define the structure of an invoice.
    public static class Invoice {
        // These are the attributes of an invoice: item name, quantity, and price.
        public String itemname;
        public int quantity;
        public double price;
        
        // This method calculates the total price of the items in the invoice.
        public double getInvoiceAmount() {
            // We simply multiply the quantity by the price per item to get the total.
            double totalPrice = quantity * price;
            return totalPrice;
        }
    }

    // Now, let's test our Invoice class with some user inputs.
    public static class InvoiceTest {
        // This is our testing method where all the magic happens!
        public static void test(String args[]) {
            // We need a way to take inputs from the user, right?
            Scanner input = new Scanner(System.in);
            
            // Let's create an invoice object to store our data.
            Invoice invoice1 = new Invoice();
            
            // Now, let's ask the user for some info about the items.
            for (int i = 0; i < 2; i++) { // We're looping twice for two items.
                System.out.printf("Please enter item name: ");
                invoice1.itemname = input.next();
                System.out.printf("Please enter item quantity: ");
                invoice1.quantity = input.nextInt();
                System.out.printf("Please enter price of each item: ");
                invoice1.price = input.nextDouble();
                
                // Now that we have all the info, let's calculate the total price.
                double totalprice = invoice1.getInvoiceAmount();
                
                // And finally, let's inform the user about their purchase!
                System.out.printf("You ordered %d %s's amounting to %.2f where %.2f is the price per item!\n", invoice1.quantity, invoice1.itemname, totalprice, invoice1.price);
            }
            
            // Don't forget to close the input scanner to avoid memory leaks.
            input.close();
        }
    }

    // And here's the main method where everything starts.
    public static void main(String[] args) {
        // We'll kick off the testing phase by calling the test method from InvoiceTest class.
        InvoiceTest.test(args);
    }
}
