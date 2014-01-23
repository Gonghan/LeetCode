package Jan;

public class MinimumDepth {

	public int minDepth(TreeNode root) {
		if (root != null) {
			return 1 + min(minDepth(root.left), minDepth(root.right));
		} else {
			return 0;
		}
	}

	private int min(int a, int b) {
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}
		return Math.min(a, b);
	}
}
