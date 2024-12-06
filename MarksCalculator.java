# Auto detect text files and perform LF normalization
* text=auto
import java.util.Scanner;

public class MarksCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Array to store marks for each subject
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Step 2: Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            // Ensure marks are within the valid range
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                i--; // Redo the current iteration if the input is invalid
                continue;
            }

            totalMarks += marks[i];
        }

        // Step 3: Calculate the total, average percentage, and assign grade
        double averagePercentage = (double) totalMarks / numSubjects;
        String grade = calculateGrade(averagePercentage);

        // Step 4: Display the results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Method to calculate grade based on average percentage
    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+ (Excellent)";
        } else if (percentage >= 80) {
            return "A (Very Good)";
        } else if (percentage >= 70) {
            return "B+ (Good)";
        } else if (percentage >= 60) {
            return "B (Above Average)";
        } else if (percentage >= 50) {
            return "C (Average)";
        } else if (percentage >= 40) {
            return "D (Pass)";
        } else {
            return "F (Fail)";
        }
    }
}