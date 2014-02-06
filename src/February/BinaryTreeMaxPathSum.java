package February;

public class BinaryTreeMaxPathSum {

	int max;

	public int maxPathSum(TreeNode root) {
		max = 0;
		if (root == null) {
			return 0;
		}
		max = root.val;
		getMax(root);
		return max;
	}

	int getMax(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = getMax(node.left);
		int right = getMax(node.right);

		int maxPath = Math.max(left, right);
		int maxValue = Math.max(maxPath, left + right);
		maxValue = Math.max(node.val, node.val + maxValue);
		max = Math.max(maxValue, max);
		return Math.max(node.val, node.val + maxPath);
	}

}
