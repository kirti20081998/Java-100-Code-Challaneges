/*
 * Given the root of a binary tree, return its maximum depth.A binary tree's maximum depth is the number 
 * of nodes along the longest path from the root node down to the farthest leaf node.
 */

package treesProgram;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class codeOne {
	
	public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // Example usage
    public static void main(String[] args) {
    	codeOne solver = new codeOne();

        // Build sample tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solver.maxDepth(root)); // Output: 3
    }

}
