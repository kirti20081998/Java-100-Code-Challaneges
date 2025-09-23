/*
 * Given the roots of two binary trees p ad q, write a function to check if they are same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes 
 * have same value.
 */

package treesProgram;

public class codeFour {
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val) 
            && isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right);
    }

    // Example usage
    public static void main(String[] args) {
    	codeFour solver = new codeFour();

        // Tree 1
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree 2
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(solver.isSameTree(p, q)); // true
    }

}
