/**
 * !Best Average Grade:
 * 
 * Given a list of student test score, find the best average grade. 
 * Each student may have more than one test score in the list.
 * Complete the function BestAverageGrade funtion in the editor below.
 * It has only one parameter, scores, which is an array of students test scores.
 * Each elements in the array is a two-element array of the form [Student name, test score e.g.,["tofik",95].
 * test score may be positive and negative Integer.
 * If you end up with an average grade that is not integer, you use a floor 
 * function to return the largest integer less than equal to the average.return 0 
 * for empty input.
 * 
 * Input:[{"bobby", 87},{"b", 100},{"B", 64},{"C",22}]
 * Expected Output is: 87
 * 
 * Example Walkthrough:
 * For the input: { {"bobby", "87"}, {"b", "100"}, {"B", "64"}, {"C", "22"} }
 * Normalized names:
 * bobby -> bobby
 * b -> b
 * B -> b (normalized to lowercase)
 * C -> c
 * Grouped scores:
 * bobby: [87] → Average = 87
 * b: [100, 64] → Average = (100 + 64) / 2 = 82
 * c: [22] → Average = 22
 * Maximum average: 87.
 * 
 * *Over All time complexity
 * O(n)
 */

package GoldManSachs.Medium;

import java.util.*;

public class BestAverageGrade {

    public static int bestAverageGrade(String[][] scores) {
        // Edge case: return 0 if input is empty
        if (scores == null || scores.length == 0) {
            return 0;
        }

        // Map to store the total score and count for each student
        Map<String, int[]> studentScores = new HashMap<>();

        // Populate the map with scores
        for (String[] entry : scores) {
            String student = entry[0].toLowerCase(); // Normalize to lowercase
            int score = Integer.parseInt(entry[1]);

            studentScores.putIfAbsent(student, new int[] { 0, 0 });
            studentScores.get(student)[0] += score; // Add the score
            studentScores.get(student)[1] += 1; // Increment the count
        }

        int maxAverage = Integer.MIN_VALUE;

        // Calculate the average for each student and find the maximum
        for (Map.Entry<String, int[]> entry : studentScores.entrySet()) {
            int totalScore = entry.getValue()[0];
            int count = entry.getValue()[1];
            int average = (int) Math.floor((double) totalScore / count);
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }

    public static void main(String[] args) {
        String[][] scores = {

                { "bobby", "87" },
                { "b", "100" },
                { "B", "64" },
                { "C", "22" },
                {"D","100"},
                {"E","200"}

                // { "Bob", "87" }, { "Mike", "35" }, { "Bob", "52" }, { "Jason", "35" }, {
                // "Mike", "55" },
                // { "Jessica", "99" }
        };

        System.out.println("The best average score is : " + bestAverageGrade(scores)); // Output: 87
    }
}