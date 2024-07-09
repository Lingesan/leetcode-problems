/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		depthFirst(root, list,k);
		return list.get(k - 1);
	}

	public void depthFirst(TreeNode root, List<Integer> list, int k) {
		if (root != null && list.size() < k) {
			depthFirst(root.left, list,k);
			list.add(root.val);
			depthFirst(root.right, list,k);
		}
	}
}