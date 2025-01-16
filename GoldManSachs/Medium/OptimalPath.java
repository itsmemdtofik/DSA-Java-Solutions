/**
 * !Optimal Path OR Maximum gold that can be collected.
 * 
 * You are an avid rock collector who lives in southern california. 
 * Some rare and desirable rocks just became available in New York, 
 * so you are planning a cross country road trip. There are several 
 * other rare rocks that you could you pickup along the the way.
 * You have been given a grid filled with numbers, respresenting the 
 * number of rocks available in various cities across the country. 
 * Your objective is to find the optimal path from So_Cal to New_York 
 * that would allow you to accumulate the most rocks along the way.
 * 
 * Note: You can only travel either north (up) or east(right)
 * 
 * For example:
    
    {{0,0,0,0,5}, New_York (finish)
     {0,1,1,1,0}
    So_Cal (Start) {2,0,0,0,0}} 
    
    the total for this example would be the 10 (2+0+1+1+1+0+5).
 */

package GoldManSachs.Medium;

public class OptimalPath {
    // Optimal Path or Find the maximum gold that can be collected
    public static int optimalPath(int grid[][]) {
        // Get the number of rows and columns in the grid
        int rows = grid.length;
        int cols = grid[0].length;

        System.out.println(cols);

        // Create a DP table to store the maximum number of rocks collected up to each cell
        int[][] dp = new int[rows][cols];

        // Initialize the bottom-left corner (start point)
        dp[rows - 1][0] = grid[rows - 1][0];

        // Fill the last row (can only move east)
        for (int col = 1; col < cols; col++) {
            dp[rows - 1][col] = dp[rows - 1][col - 1] + grid[rows - 1][col];
        }

        // Fill the first column (can only move north)
        for (int row = rows - 2; row >= 0; row--) {
            dp[row][0] = dp[row + 1][0] + grid[row][0];
        }

        // Fill the rest of the DP table
        for (int row = rows - 2; row >= 0; row--) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = Math.max(dp[row + 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }

        // The top-right corner contains the maximum number of rocks that can be
        // collected
        return dp[0][cols - 1];
    }

    // Example usage
    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 0, 0, 5 },
                { 0, 1, 1, 1, 0 },
                { 2, 0, 0, 0, 0 }
        };

        System.out.println("Maximum rocks collected: " + optimalPath(grid));
    }
}
