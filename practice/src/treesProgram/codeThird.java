/*
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has 
 * an edge connecting them.A node can only appear in the sequence at most once.Note that the path does 
 * not need to pass through the root. The path sum of a path is the sum of the node's value in the path. 
 * Given the root of the binary tree, return the maximum path sum of any non -empty path.
 */

package treesProgram;

public class codeThird {
	
	private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Max gain from left and right (ignore negative paths)
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // Path that passes through this node
        int localMax = node.val + leftGain + rightGain;

        // Update global maximum
        maxSum = Math.max(maxSum, localMax);

        // Return path sum upward (choose best side)
        return node.val + Math.max(leftGain, rightGain);
    }

    // Example usage
    public static void main(String[] args) {
    	codeThird solver = new codeThird();

        // Build tree: [-10,9,20,null,null,15,7]
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solver.maxPathSum(root)); // Output: 42
    }

}
