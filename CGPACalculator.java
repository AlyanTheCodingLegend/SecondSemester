import java.util.Scanner;

public class CGPACalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            if (numSubjects <= 0) {
                throw new IllegalArgumentException("Number of subjects must be positive.");
            }

            double[] scores = new double[numSubjects];

            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter score for subject " + (i + 1) + ": ");
                scores[i] = scanner.nextDouble();
                if (scores[i] < 0) {
                    throw new IllegalArgumentException("Score of a subject must be positive.");
                }
            }

            double totalScore = 0;
            for (double score : scores) {
                totalScore += score;
            }

            double cgpa = totalScore / numSubjects;
            System.out.println("CGPA for the semester: " + cgpa);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds.");
        } finally {
            scanner.close();
        }
    }
}

