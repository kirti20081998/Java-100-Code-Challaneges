/*
 * Given a binary tree, find the lowest common ancestor(LCA) of two given nodes in the tree
 */

package treesProgram;

public class codeSix {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root; // p and q found in different subtrees
        }
        return (left != null) ? left : right;
    }

    // Example usage
    public static void main(String[] args) {
    	codeSix solver = new codeSix();

        // Build tree: [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // Node 5
        TreeNode q = root.left.right.right; // Node 4

        TreeNode lca = solver.lowestCommonAncestor(root, p, q);
        System.out.println(lca.val); // Output: 5
    }

}
