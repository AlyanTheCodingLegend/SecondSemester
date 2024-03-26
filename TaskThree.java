import java.util.Scanner; // importing the scanner class to enable I/O operations

public class TaskThree {
    public static void main(String args[]) {
        boolean seats[] = {false,false,false,false,false,false,false,false,false,false};
        Scanner input=new Scanner(System.in);
        int userInp=-1;
        int seatNum=-1;
        int relocate=1;
        boolean rowIsFull=true;
        int tickets;
        System.out.println("Please enter the number of tickets that you want to book: ");
        tickets=input.nextInt();
        for (int k=0;k<tickets;k++) { // looping through and booking the number of tickets specified
            System.out.println("Please enter 1 for front row and 2 for second row: ");
            userInp=input.nextInt();
            relocate=1;
            seatNum=-1;
            rowIsFull=true;
            while (relocate==1) { // looping until relocating of seats is done
                if (userInp==1) { 
                    for (int i=0;i<5;i++) {
                        if (seats[i]==false) {
                            rowIsFull=false;
                            relocate=0;
                            seats[i]=true;
                            seatNum=i+1;
                            break;
                        }
                    }
                    if (rowIsFull==true) { // prompting user to relocate
                        System.out.println("Is it acceptable for you to get a seat in the second row? Type 0 for NO or 1 for YES: ");
                        relocate=input.nextInt();
                        if (relocate==0) {
                            System.out.println("You can try booking the ride in the next slot.");
                        } else {
                            userInp=2;
                        }
                    }
                }
                else if (userInp==2) {
                    for (int i=5;i<10;i++) {
                        if (seats[i]==false) {
                            rowIsFull=false;
                            relocate=0;
                            seats[i]=true;
                            seatNum=i+1;
                            break;
                        }
                    }
                    if (rowIsFull==true) { // prompting user to relocate
                        System.out.println("Is it acceptable for you to get a seat in the first row? Type 0 for NO or 1 for YES: ");
                        relocate=input.nextInt();
                        if (relocate==0) {
                            System.out.println("You can try booking the ride in the next slot.");
                        } else {
                            userInp=1;
                        }
                    }
                }
            }
            System.out.printf("Row number: %d\n",userInp);
            System.out.printf("Seat number: %d\n", seatNum);
        }    
        System.out.println("Seats (T for booked, F for not booked): \n");
        for (boolean seat:seats) { // outputting the seats through enhanced for loop
            if (seat==true) {
                System.out.println("T-");
            }
            else {
                System.out.println("F-");
            }
        }
        input.close(); // closing the scanner to avoid data leaks
    
    }
}