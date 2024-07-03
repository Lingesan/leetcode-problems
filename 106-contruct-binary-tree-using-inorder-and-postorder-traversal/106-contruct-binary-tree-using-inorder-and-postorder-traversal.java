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
    public TreeNode buildTree(int[] inorder, int[] postOrder) {
        if (postOrder.length == 0) {
            return null;
        }
        if (postOrder.length == 1) {
            return new TreeNode(postOrder[0]);
        }
        int root = postOrder[postOrder.length - 1];
        int position = findIndex(inorder, root);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, position);
        int[] rightInOrder = Arrays.copyOfRange(inorder, position + 1, inorder.length);
        int[] leftPostOrder = Arrays.copyOfRange(postOrder, 0, leftInOrder.length);
        int[] rightPostOrder = Arrays.copyOfRange(postOrder, leftInOrder.length, postOrder.length - 1);

        TreeNode rootNode = new TreeNode(root);
        rootNode.left = buildTree(leftInOrder, leftPostOrder);
        rootNode.right = buildTree(rightInOrder, rightPostOrder);
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