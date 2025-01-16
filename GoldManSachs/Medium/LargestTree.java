/**
 * !Root of the largest tree.
 * 
 * A forest is represented with a hashmap. 
 * This hashmap has this key -> value relationship: child -> parent.
 * Every node has a unique integer element. 
 * I needed to find out the largest tree's root node. 
 * If there is a tie, return the smallest root.
 * 
 * The tree with the highest number of nodes, is the largest one. 
 * The edges are directed from parent to child.
 * 
 * Input:{{1 -> 2}, {3 -> 4}}
 * Output: 2
 * 
 * I first found out the roots present in the forest. 
 * Then created an adjacency list and applied BFS to count the nodes. 
 * Maintained the maximum count and root with the largest tree in two variables.
 */

/**
 * 
 * *Step 1: Understand the Problem
 * We have a forest of directed trees represented as 
 * a child -> parent map. We need to:
 * Identify the root nodes in the forest.
 * Find the size of each tree (number of nodes in the tree).
 * Determine the root of the largest tree. If there’s a tie (multiple trees with the same size), return the smallest root.
 * 
 * ? Step 2: Key Observations
 * Root nodes are nodes that do not appear as children in the map.
 * Example: If child -> parent is {1 -> 2, 3 -> 4}, then:
 * 
 * All nodes = {1, 2, 3, 4} -> 4
 * Children = {1, 3} -> 2
 * Roots = All nodes(4) - Children(2) = {2, 4} -> 2
 * 
 * ? Step2: Represent the forest using an adjacency list for easy traversal.
 * Adjacency list:
 * Parent → List of children.
 * Example: For {1 -> 2, 3 -> 4}, adjacency list = {2 -> [1], 4 -> [3]}.
 * 
 * ?Traverse each tree using BFS or DFS starting from each root and count its size.
 * Track the largest tree’s root and its size. Use:
 * maxSize to track the size of the largest tree.
 * largestTreeRoot to track the root of the largest tree.
 * If sizes are tied, choose the smaller root.
 */

package GoldManSachs.Medium;

import java.util.*;

public class LargestTree {

    public static int findLargestTreeRoot(Map<Integer, Integer> childToParent) {
        Set<Integer> allNodes = new HashSet<>(childToParent.keySet());
        allNodes.addAll(childToParent.values());

        Set<Integer> children = childToParent.keySet();
        List<Integer> roots = new ArrayList<>();
        for (int node : allNodes) {
            if (!children.contains(node)) {
                roots.add(node);
            }
        }

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : childToParent.entrySet()) {
            int child = entry.getKey();
            int parent = entry.getValue();
            adjacencyList.computeIfAbsent(parent, _ -> new ArrayList<>()).add(child);
        }

        int maxSize = 0;
        int largestTreeRoot = Integer.MAX_VALUE;
        for (int root : roots) {
            int size = bfs(root, adjacencyList);
            if (size > maxSize || (size == maxSize && root < largestTreeRoot)) {
                maxSize = size;
                largestTreeRoot = root;
            }
        }

        return largestTreeRoot;
    }

    private static int bfs(int root, Map<Integer, List<Integer>> adjacencyList) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            List<Integer> children = adjacencyList.getOrDefault(current, new ArrayList<>());
            for (int child : children) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(child);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Map<Integer, Integer> childToParent = new HashMap<>();
        childToParent.put(1, 2);
        childToParent.put(3, 4);

        int largestTreeRoot = findLargestTreeRoot(childToParent);
        System.out.println("Root of the largest tree: " + largestTreeRoot);
    }
}
