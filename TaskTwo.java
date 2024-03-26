import java.util.Scanner; // importing the scanner class to enable I/O operations

public class TaskTwo {
    public static void main(String args[]) {
        int ages[] = new int[15]; // initializing the ages array to store 15 ages
        Scanner input = new Scanner(System.in); // initializing scanner as input
        int above=0;
        String bar1="";
        String bar2="";
        for (int i=0;i<15;i++) { // taking age as input 15 times and storing it
            System.out.println("Please enter the age: ");
            int age=input.nextInt();
            if (age<18) {
                bar1=bar1+"*";
            }
            else {
                above+=1;
                bar2=bar2+"*";
            }
            ages[i]=age;
        }
        input.close(); // closing the scanner to avoid data leaks
        System.out.printf("Below 18: %s\n", bar1); // outputting the required data of people who can vote
        System.out.printf("18 or Above: %s\n", bar2);
        System.out.printf("%d people can vote", above);
    }
}


