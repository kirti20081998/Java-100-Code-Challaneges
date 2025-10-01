/* 
 *Given the root of a binary tree, determine if it is a valid binary search tree(BST). 
 */

package treesProgram;

public class codeNine {
	
	public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long low, long high) {
        if (node == null) return true;

        if (node.val <= low || node.val >= high) {
            return false;
        }

        return validate(node.left, low, node.val) &&
               validate(node.right, node.val, high);
    }

    // Example usage
    public static void main(String[] args) {
    	codeNine solver = new codeNine();

        // Build tree: [2,1,3] -> valid BST
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(solver.isValidBST(root)); // true
    }

}
