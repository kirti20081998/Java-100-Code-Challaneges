/*
 * Given the root of the binary tree, invert the tree and return its root
 */

package treesProgram;

public class codeSecond {
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recurse for children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // Example usage
    public static void main(String[] args) {
    	codeSecond solver = new codeSecond();

        // Build tree: [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode inverted = solver.invertTree(root);
        // After inversion: [4,7,2,9,6,3,1]
        System.out.println(inverted.val); // 4 (root stays same)
    }

}
