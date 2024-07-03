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
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		if (preorder.length == 1) {
			return new TreeNode(preorder[0]);
		}
		int root = preorder[0];
		int position =findIndex(inorder,root);
		int[] leftInOrder = Arrays.copyOfRange(inorder, 0, position);
		int[] rightInOrder = Arrays.copyOfRange(inorder, position + 1, inorder.length);
		int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, leftInOrder.length + 1);
		int[] rightPreOrder = Arrays.copyOfRange(preorder, leftInOrder.length + 1, preorder.length);

		TreeNode rootNode = new TreeNode(root);
		rootNode.left = buildTree(leftPreOrder, leftInOrder);
		rootNode.right = buildTree(rightPreOrder, rightInOrder);
		return rootNode;
	}

	public int findIndex(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
			if (value == arr[i]) {
				return i;
			}
		}
		return -1;
	}
}