    /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode() {}
    *     TreeNode(int val) { this.val = val; }
    *     TreeNode(int val, TreeNode left, TreeNode right) {
    *         this.val = val;
    *         this.left = left;
    *         this.right = right;
    *     }
    * }
    */
    class Solution {
    	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		flatten(left);
		flatten(right);
		root.right = left;
		root.left = null;
		if (left == null) {
			root.right = right;
		} else {
			TreeNode lastRight = root.right;
			while (lastRight.right != null) {
				lastRight = lastRight.right;
			}
			lastRight.right = right;
		}
	}
}