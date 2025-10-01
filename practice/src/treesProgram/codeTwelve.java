package treesProgram;

public class codeTwelve {
	
	public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1; // left subtree not balanced

        int right = checkHeight(node.right);
        if (right == -1) return -1; // right subtree not balanced

        if (Math.abs(left - right) > 1) return -1; // current node not balanced

        return 1 + Math.max(left, right); // height of subtree
    }

    // Example usage
    public static void main(String[] args) {
    	codeTwelve solver = new codeTwelve();

        // Build tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solver.isBalanced(root)); // true
    }

}
