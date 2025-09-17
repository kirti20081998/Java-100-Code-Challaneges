package linklistProgram;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class codeTen {
	
	private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // Process right subtree first
        flatten(root.right);
        // Then process left subtree
        flatten(root.left);

        // Rewire pointers
        root.right = prev;
        root.left = null;

        // Move prev to current node
        prev = root;
    }

    // Helper: print flattened tree
    public void printFlattened(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("null");
    }

    // Example usage
    public static void main(String[] args) {
    	codeTen solution = new codeTen();

        // Build sample tree:
        //       1
        //      / \
        //     2   5
        //    / \   \
        //   3   4   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        solution.flatten(root);

        System.out.println("Flattened tree (as linked list):");
        solution.printFlattened(root);
    }

}
