/*
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree 
 * and inorder is the inorder traversal of the same tree , construct and return the binary tree.
 */

package treesProgram;

import java.util.HashMap;
import java.util.Map;

public class codeSeven {
	
	private int preorderIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build hashmap for quick lookup of inorder index
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        // Get root value from preorder
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder
        int inorderIndex = inorderMap.get(rootVal);

        // Build left and right subtrees
        root.left = helper(preorder, inLeft, inorderIndex - 1);
        root.right = helper(preorder, inorderIndex + 1, inRight);

        return root;
    }

    // Example usage
    public static void main(String[] args) {
    	codeSeven solver = new codeSeven();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = solver.buildTree(preorder, inorder);
        System.out.println(root.val); // Output: 3
        System.out.println(root.left.val); // Output: 9
        System.out.println(root.right.val); // Output: 20
    }

}
