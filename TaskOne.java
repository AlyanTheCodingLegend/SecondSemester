import java.util.Scanner; // importing the scanner class to enable I/O operations

public class TaskOne {
    public static void main(String args[]) {
        Scanner input= new Scanner(System.in); // initializing scanner as input
        System.out.println("Please enter a binary number: "); // taking a binary integer as input
        int binary = input.nextInt();
        int decimal=0;
        int base=1;
        while (binary>0) { // looping through the entire binary integer and converting it to decimal
            int remainder = binary %10;
            decimal+=remainder*base;
            base*=2;
            binary/=10;
        }
        System.out.printf("Decimal number: %d",decimal); // outputting the decimal form
        input.close(); // closing the scanner to avoid data leaks
    }
}

