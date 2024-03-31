import java.util.Random;
import java.util.Scanner;

public class GradeBookHW {
    private static final int NUM_STUDENTS = 5;
    private static final int NUM_GRADES = 11;
    private static final int MIN_GRADE = 15;
    private static final int MAX_GRADE = 25;

    public static void main(String[] args) {
        int[] grades = new int[NUM_STUDENTS * NUM_GRADES];

        
        initializeGrades(grades);

        
        System.out.println("\nOriginal HW grades:");
        printTableHeader();
        for (int i = 0; i < NUM_STUDENTS; i++) {
            displayGradeRow(grades, i * NUM_GRADES, (i + 1) * NUM_GRADES);
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPress Enter to remove the lowest HW score and calculate total for all students:");
        scanner.nextLine();
        scanner.close();
        
        System.out.println("\nUpdated HW grades and total:");
        printUpdatedTableHeader();
        for (int i = 0; i < NUM_STUDENTS; i++) {
            displayUpdatedGradeRow(grades, i * NUM_GRADES, (i + 1) * NUM_GRADES);
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    private static void initializeGrades(int[] grades) {
        Random rand = new Random();
        for (int i = 0; i < grades.length; i++) {
            grades[i] = rand.nextInt(MAX_GRADE - MIN_GRADE + 1) + MIN_GRADE;
        }
    }

    private static int findLowestIndex(int[] studentGrades, int start, int end) {
        int lowest = studentGrades[start];
        int lowestIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (studentGrades[i] < lowest) {
                lowest = studentGrades[i];
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    private static void displayGradeRow(int[] grades, int start, int end) {
        System.out.print("|\t");
        for (int i = start; i < end; i++) {
            System.out.print(grades[i] + "\t|\t");
        }
        System.out.println();
    }

    private static void displayUpdatedGradeRow(int[] grades, int start, int end) {
        int lowestIndex = findLowestIndex(grades, start, end);
        grades[lowestIndex] = 0;

        int total = 0;
        System.out.print("|\t");
        for (int i = start; i < end; i++) {
            System.out.print(grades[i] + "\t|\t");
            total += grades[i];
        }
        System.out.printf("%d\t\t|\n",total);
    }

    private static void printTableHeader() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("|\tHW1\t|\tHW2\t|\tHW3\t|\tHW4\t|\tHW5\t|\tHW6\t|\tHW\t|\tHW8\t|\tHW9\t|\tHW10\t|\tHW11\t|\n");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void printUpdatedTableHeader() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("|\tHW1\t|\tHW2\t|\tHW3\t|\tHW4\t|\tHW5\t|\tHW6\t|\tHW7\t|\tHW8\t|\tHW9\t|\tHW10\t|\tHW11\t|\tHW TOTAL\t|\n");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
