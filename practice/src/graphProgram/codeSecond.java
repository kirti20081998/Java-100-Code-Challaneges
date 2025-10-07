/*
 Given is a 2D adjacecy list representation of a graph.Check whether the graph is a Bipartite graph.
 */

package graphProgram;

import java.util.LinkedList;
import java.util.Queue;

public class codeSecond {
	
	public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0 = uncolored, 1 = red, -1 = blue

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) { // not yet colored, start BFS
                if (!bfsCheck(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfsCheck(int[][] graph, int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1; // start with color 1

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) {
                    // Assign opposite color to neighbor
                    color[neighbor] = -color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    // Same color adjacent => Not bipartite
                    return false;
                }
            }
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
    	codeSecond solver = new codeSecond();

        // Example 1: Bipartite graph
        int[][] graph1 = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };
        System.out.println(solver.isBipartite(graph1)); // true

        // Example 2: Not Bipartite
        int[][] graph2 = {
            {1, 2, 3},
            {0, 2},
            {0, 1, 3},
            {0, 2}
        };
        System.out.println(solver.isBipartite(graph2)); // false
    }

}
