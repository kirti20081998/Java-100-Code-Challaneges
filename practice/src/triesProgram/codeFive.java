/*
 Given an m X n board of characters and a list of strings words, return all words on the board.Each word
 must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or 
 vertically neighboring. The same letter cell may not be used more than once in a word.
 */

package triesProgram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrieNode2 {
    TrieNode2[] children = new TrieNode2[26];
    String word = null; // store word when end reached
}

public class codeFive {
	
	private TrieNode2 root = new TrieNode2();
    private Set<String> result = new HashSet<>();
    private int m, n;

    public List<String> findWords(char[][] board, String[] words) {
        // 1. Build Trie
        for (String w : words) insert(w);

        m = board.length;
        n = board[0].length;

        // 2. DFS search starting from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return new ArrayList<>(result);
    }

    private void insert(String word) {
        TrieNode2 node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode2();
            node = node.children[idx];
        }
        node.word = word; // mark end
    }

    private void dfs(char[][] board, int i, int j, TrieNode2 node) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        // Mark visited
        board[i][j] = '#';

        // Explore neighbors
        if (i > 0) dfs(board, i - 1, j, node);
        if (j > 0) dfs(board, i, j - 1, node);
        if (i < m - 1) dfs(board, i + 1, j, node);
        if (j < n - 1) dfs(board, i, j + 1, node);

        // Restore cell
        board[i][j] = c;
    }

    // Example usage
    public static void main(String[] args) {
    	codeFive solver = new codeFive();
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

        System.out.println(solver.findWords(board, words));
        // Output: [oath, eat]
    }

}
