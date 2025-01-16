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
