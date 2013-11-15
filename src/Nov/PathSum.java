package Nov;

//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
public class PathSum {

	public static void main(String args[]) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		root.left = b;
		System.out.println(solution.hasPathSum(root, 1));
	}
}

class Solution {
	private boolean found;

	public boolean hasPathSum(TreeNode root, int sum) {
		this.found = false;
		pathSum(root, 0, sum);
		return found;

	}

	// return the sum of a path, from root to the current node
	// current_sum records the sum of the current path(not containing node)
	private void pathSum(TreeNode node, int current_sum, int sum) {
		if (this.found == true) {
			return;
		}
		if (node == null) {
			return;
		}
		current_sum += node.val;
		if(current_sum==sum && node.left==null && node.right==null){
			this.found = true;
			return;
		}

		if (node.left != null) {
			pathSum(node.left, current_sum, sum);
		}
		if (node.right != null) {
			pathSum(node.right, current_sum, sum);
		}

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}