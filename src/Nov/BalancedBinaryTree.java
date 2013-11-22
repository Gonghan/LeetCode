package Nov;

/*
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
		public boolean isBalanced(TreeNode root) {
			return checkBalanced(root);
		}

		private boolean checkBalanced(TreeNode node) {
			if (node == null) {
				return true;
			}
			if (!checkNode(node)) {
				return false;
			}
			return checkBalanced(node.left) && checkBalanced(node.right);
		}

		// return the depth of a tree
		private int depth(TreeNode node) {
			if (node == null) {
				return 0;
			}
			return 1 + Math.max(depth(node.left), depth(node.right));
		}

		private boolean checkNode(TreeNode node) {
			if (node == null) {
				return true;
			}
			int leftDepth = depth(node.left);
			int rightDepth = depth(node.right);
			if (Math.abs(leftDepth - rightDepth) <= 1) {
				return true;
			} else {
				return false;
			}
		}
	}
}
