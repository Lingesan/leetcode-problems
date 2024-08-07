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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>(100);
        return rightSideView(root, list, 0);
    }

    private List<Integer> rightSideView(TreeNode root, List<Integer> list, int depth) {
        if (root != null) {
            if (list.size() <= depth) {
                list.add(root.val);
            }
            rightSideView(root.right, list, depth + 1);
            rightSideView(root.left, list, depth + 1);
        }
        return list;
    }
}