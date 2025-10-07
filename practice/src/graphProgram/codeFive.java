/*
 There are n cities connected bby some number of flights.You are given an array flights where 
 flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost 
 pricei. You are also given three integers src, dst, and k, return the cheapest price from src to dst with 
 at most k stops.If there is no such route, return -1
 */

package graphProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class codeFive {
	
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], a -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }

        // Min-heap: [cost, node, stops]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0});

        // Keep track of best cost for (city, stops)
        int[][] best = new int[n][k + 2];
        for (int[] row : best) Arrays.fill(row, Integer.MAX_VALUE);
        best[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], city = curr[1], stops = curr[2];

            // If destination reached
            if (city == dst) return cost;

            // If stops exceed limit, skip
            if (stops > k) continue;

            // Explore neighbors
            if (graph.containsKey(city)) {
                for (int[] next : graph.get(city)) {
                    int nextCity = next[0];
                    int nextCost = cost + next[1];

                    // Only push if cheaper for given stop count
                    if (nextCost < best[nextCity][stops + 1]) {
                        best[nextCity][stops + 1] = nextCost;
                        pq.offer(new int[]{nextCost, nextCity, stops + 1});
                    }
                }
            }
        }
        return -1; // no valid path
    }

    // Example usage
    public static void main(String[] args) {
    	codeFive solver = new codeFive();

        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 3, 100},
            {0, 2, 500}
        };
        int src = 0, dst = 3, k = 1;

        System.out.println(solver.findCheapestPrice(n, flights, src, dst, k)); 
    }

}
