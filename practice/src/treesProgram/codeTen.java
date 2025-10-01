/*
 *Given the root of a binary search tree, and an integer k, return the kth smallest value(1-indexed) of all 
 *the values of the nodes in the tree. 
 */

package treesProgram;

public class codeTen {
	
	private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }

    // Example usage
    public static void main(String[] args) {
    	codeTen solver = new codeTen();

        // Build BST: [3,1,4,null,2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        System.out.println(solver.kthSmallest(root, 1)); // Output: 1
    }

}
