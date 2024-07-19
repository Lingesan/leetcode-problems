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
	public TreeNode sortedArrayToBST(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		boolean[] visited = new boolean[nums.length];
		return sortedArrayToBST(nums, start, end, visited);
	}

	private TreeNode sortedArrayToBST(int[] nums, int start, int end, boolean[] visited) {
		int middle = (start + end) / 2;
		if (middle < 0 || middle > nums.length - 1 || visited[middle]) {
			return null;
		}
		TreeNode root = new TreeNode(nums[middle]);
		visited[middle] = true;
		root.left = sortedArrayToBST(nums, start, middle - 1, visited);
		root.right = sortedArrayToBST(nums, middle + 1, end, visited);
		return root;
	}
}