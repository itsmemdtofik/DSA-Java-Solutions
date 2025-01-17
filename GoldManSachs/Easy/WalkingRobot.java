/**
 * !Walking Rebot:
 * 
 * Instructions:Implement the walk method. this method takes in a string path 
 * where each character in the string corresponds to a potential movements of the robot.
 * the robot can move up, down, left and right represented by the 
 * character 'U','D','L' and 'R' respectively. All other character may be ignored. 
 * Assume the robot's initial position is at (0,0). 
 * The output of this method is the robot's final x and y cordinates relative 
 * to the initial position.
 */
package GoldManSachs.Easy;

import java.util.Arrays;

public class WalkingRobot {
    public static Integer[] walk(String path) {
        // Initialize robot's position at (0, 0)
        int x = 0;
        int y = 0;

        // Loop through each character in the path
        for (char move : path.toCharArray()) {
            switch (move) {
                case 'U': // Move up
                    y++;
                    break;
                case 'D': // Move down
                    y--;
                    break;
                case 'L': // Move left
                    x--;
                    break;
                case 'R': // Move right
                    x++;
                    break;
                // Ignore other characters
            }
        }

        // Return final position
        return new Integer[] { x, y };
    }

    public static void main(String[] args) {
        String path = "ULDR";
        Integer[] result = walk(path);
        System.out.println(Arrays.toString(result)); // Expected output: [0, 0]

    }
}
