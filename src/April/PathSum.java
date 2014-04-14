package April;

import February.TreeNode;

public class PathSum {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		root.left = b;
		System.out.println(new PathSum().hasPathSum(root, 1));
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		int value = root.val;
		if (isLeaf(root) && value == sum) {
			return true;
		}
		return hasPathSum(root.left, sum - value)
				| hasPathSum(root.right, sum - value);
	}

	boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}
}
