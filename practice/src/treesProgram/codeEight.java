/*
 * Given the root of a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 */

package treesProgram;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class codeEight {
	
	 public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        if (root == null) return result;

	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);

	        while (!queue.isEmpty()) {
	            int size = queue.size();

	            for (int i = 0; i < size; i++) {
	                TreeNode node = queue.poll();

	                // If it's the last node of the level, add to result
	                if (i == size - 1) {
	                    result.add(node.val);
	                }

	                if (node.left != null) queue.offer(node.left);
	                if (node.right != null) queue.offer(node.right);
	            }
	        }

	        return result;
	    }

	    // Example usage
	    public static void main(String[] args) {
	    	codeEight solver = new codeEight();

	        // Build tree: [1,2,3,null,5,null,4]
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.right = new TreeNode(5);
	        root.right.right = new TreeNode(4);

	        System.out.println(solver.rightSideView(root)); // [1, 3, 4]
	    }

}
