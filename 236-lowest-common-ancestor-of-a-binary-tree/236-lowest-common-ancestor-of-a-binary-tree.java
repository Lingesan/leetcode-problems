/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> list = new ArrayList<>();
		findPath(root, p, list);

		List<TreeNode> list2 = new ArrayList<>();
		findPath(root, q, list2);
		Collections.reverse(list);
		for(TreeNode node:list){
			if(list2.contains(node)){
				return node;
			}
		}
		return null;
	}

	public boolean findPath(TreeNode root, TreeNode p, List<TreeNode> path) {
		if (root == null) {
			return false;
		}
		if (root.val == p.val) {
			path.add(root);
			return true;
		}
		path.add(root);
		if (findPath(root.left, p, path) || findPath(root.right, p, path)) {
			return true;
		}
		path.remove(root);
		return false;
	}
}