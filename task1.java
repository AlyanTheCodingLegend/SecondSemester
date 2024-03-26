// Importing the scanner class to enable I/O operations
import java.util.Scanner;

public class task1 {
    // This method calculates the average runs per match for a given category.
    public static void calculateAverage(String category, int ...runs) {
        int total=0; // We'll keep track of the total runs scored.
        double avg=0.0; // This will hold the average runs per match.
        int matches=runs.length; // We count how many matches we have info for.

        // Time to sum up all the runs across matches.
        for (int runsPerMatch: runs) {
            total+=runsPerMatch;
        }
        // Now, let's calculate the average.
        avg = ((double)total/(double)matches);

        // Let's print out the result in a nice way.
        System.out.printf("The average runs per match of category %s are: %f", category, avg);
    }

    // Our main function where all the action starts.
    public static void main(String args[]) {
        // First, we need a way to take inputs from the user.
        Scanner input=new Scanner(System.in);

        // Let's ask the user for the match category.
        System.out.println("Please enter the category (T20, ODI, TEST): ");
        String category=input.next(); // We'll store the category entered by the user here.

        // Now, we handle different categories differently using a switch statement.
        int runs1,runs2,runs3,runs4,runs5; // We'll store runs for matches here, depending on the category.

        switch (category) {
            case "T20":
                // For T20, we ask for runs of 5 matches. Let's get those numbers.
                System.out.println("Please enter runs of the first match: ");
                runs1=input.nextInt();
                System.out.println("Please enter runs of the second match: ");
                runs2=input.nextInt();
                System.out.println("Please enter runs of the third match: ");
                runs3=input.nextInt();
                System.out.println("Please enter runs of the fourth match: ");
                runs4=input.nextInt();
                System.out.println("Please enter runs of the fifth match: ");
                runs5=input.nextInt();
                // Now that we have all the runs, let's calculate the average.
                calculateAverage(category, runs1,runs2,runs3,runs4,runs5);
                break;

            case "ODI":
                // For ODI, we ask for runs of 3 matches.
                System.out.println("Please enter runs of the first match: ");
                runs1=input.nextInt();
                System.out.println("Please enter runs of the second match: ");
                runs2=input.nextInt();
                System.out.println("Please enter runs of the third match: ");
                runs3=input.nextInt();
                // Let's calculate the average for ODI matches.
                calculateAverage(category, runs1,runs2,runs3);
                break;

            case "TEST":
                // For TEST matches, we only need runs of 2 matches.
                System.out.println("Please enter runs of the first match: ");
                runs1=input.nextInt();
                System.out.println("Please enter runs of the second match: ");
                runs2=input.nextInt();
                // Time to find out the average runs per match in TEST matches.
                calculateAverage(category, runs1,runs2);
                break;

            default:
                // Oops! If the user entered something other than T20, ODI, or TEST, we let them know it's wrong.
                System.out.println("Wrong input!");        
        }
        // Don't forget to close the input scanner to avoid memory leaks.
        input.close();
    }
}
