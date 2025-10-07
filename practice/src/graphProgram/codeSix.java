/*
 There are n cities. Some of them are connected, while some are ot.If city a is connected directly with 
 city b, and city b is connected directly with city c, then city a is connected indirectly with city c.A 
 province is a group of directly or indirectly connected cities nd no other cities outside of the group. 
 You are give an n X n matrix is conected where isConnected[i][j] = 1 if the ith city and jth city are 
 directly connected , and isConnected[i][j] = 0 otherwise . Return the total number of provinces.
 */

package graphProgram;

public class codeSix {
	
	public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++; // Found a new province
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
    	codeSix solver = new codeSix();

        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        System.out.println(solver.findCircleNum(isConnected)); // Output: 2
    }

}
