package triesProgram;

class TrieNode1 {
    TrieNode1[] children = new TrieNode1[2]; // 0 or 1
}

public class codeThird {
	
	private TrieNode1 root;

    public int findMaximumXOR(int[] nums) {
        root = new TrieNode1();

        // Insert all numbers into trie
        for (int num : nums) {
            insert(num);
        }

        int maxXor = 0;
        for (int num : nums) {
            maxXor = Math.max(maxXor, query(num));
        }
        return maxXor;
    }

    private void insert(int num) {
        TrieNode1 node = root;
        for (int i = 31; i >= 0; i--) { // 32-bit integer
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode1();
            }
            node = node.children[bit];
        }
    }

    private int query(int num) {
        TrieNode1 node = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggled = 1 - bit; // opposite bit
            if (node.children[toggled] != null) {
                xor |= (1 << i);
                node = node.children[toggled];
            } else {
                node = node.children[bit];
            }
        }
        return xor;
    }

    // Example usage
    public static void main(String[] args) {
    	codeThird solver = new codeThird();
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(solver.findMaximumXOR(nums)); // 28
    }

}
