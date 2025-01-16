/**
 * *Sort Segments
 * 
 * Question: Given a jumbled collection of segments, each of which is represented
 * as a Pair(startPoint, endPoint). This function sort the segment to make a continous
 * path.
 * 
 * A few assumption you can make:
 * Each segment particularly goes in one direction only if you see (1,2) you will
 * not see (2,1).
 * Each starting point only have one way to the end point for example if you see
 * (6,5) then you will not see (6,10) and (6,3).
 * 
 * If you are passed a list contaning the following in array [(4,5),(9,4),(5,1),(11,9)].
 * Then your implementation should short this such that it should come 
 * like this [(11,9),(9,4),(4,5),(5,1)]
 * 
 * Explanation:
 * Step 1: We build a map (map) where the key is the start point (left) and 
 * the value is the corresponding Pair object.
 * Step 2: We identify the start point by finding an element in the starts 
 * set that doesn't exist in the ends set.
 * Step 3: We use the map to reconstruct the sorted path by starting from 
 * the identified start point and following the segments sequentially 
 * based on the end point of each segment.
 * Step 4: The result is a sorted list of pairs forming a continuous path.
 * 
 */

package GoldManSachs.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

//Custom exception for path issue
class NoPathFoundException extends Exception {
    public NoPathFoundException(String message) {
        super(message);
    }
}

public class SegmentSort {

    public static class Pair {
        private int left;
        private int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "(" + left + "," + right + ")";
        }
    }

    /**
     * Example Walkthrough:
     * Given the segments [(4,5), (9,4), (5,1), (11,9)]:
     * Data Structures:
     * map: Maps start points to their corresponding segments, e.g., {4 -> (4,5),
     * 9-> (9,4), 5 -> (5,1), 11 -> (11,9)}
     * 
     * starts: Set of all start points {4, 9, 5, 11}
     * ends: Set of all end points {5, 4, 1, 9}
     * 
     * Find the Starting Point:
     * The starting point is 11 because it's in starts but not in ends.
     * 
     * Reconstruct the Path:
     * Start with (11,9), follow to (9,4), then (4,5), and finally (5,1).
     * 
     * Final Output:
     * The sorted path: [(11,9), (9,4), (4,5), (5,1)].
     */

    public static List<Pair> sortSegment(final List<Pair> segment) throws Exception {

        // Create a Map to find the next pair based on the right endpoint of the current
        // pair.
        Map<Integer, Pair> map = new HashMap<>();

        Set<Integer> starts = new HashSet<>();

        Set<Integer> ends = new HashSet<>();

        for (Pair p : segment) {
            map.put(p.getLeft(), p);
            starts.add(p.getLeft());
            ends.add(p.getRight());
        }

       
        /**
         * Find a starting point, which is a start point but not set end.
         * To find the start point of the continuous path, we look for a point that
         * appears in the start set but doest not appear in end set.
         * 
         * Point 11 is in starts but not in ends, meaning 11 is the starting point
         * because it is the only point that does not have any segment pointing to it as
         * an endpoint.
         * Points 4, 9, and 5 are present in both starts and ends, meaning they are not
         * the starting point because
         * they are connected to other segments, and thus can be intermediate points in
         * the path.
         * 
         */
        Integer startPoint = 0;
        for (Integer i : starts) {
            if (!ends.contains(i)) {
                startPoint = i;
                break;
            }
        }

        // If no start point is found, the segment might be disconnected, throw an
        // exception.
        if (startPoint == null) {
            throw new NoPathFoundException("No continous path is found!");
        }

        // Reconstruct the path
        List<Pair> sortedSegment = new ArrayList<>();
        Pair current = map.get(startPoint);
        while (current != null) {
            sortedSegment.add(current);
            current = map.get(current.getRight());
        }

        return sortedSegment;
    }

    public static void main(String[] args) throws Exception {

        List<Pair> segments = Arrays.asList(
                new Pair(4, 5),
                new Pair(9, 4),
                new Pair(5, 1),
                new Pair(11, 9));

        try {
            List<Pair> sortedSegments = sortSegment(segments);
            for (Pair p : sortedSegments) {
                System.out.print(p + " ");
            }
        } catch (NoPathFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
