package February;

import java.util.ArrayList;

public class PathSumII {

	private ArrayList<ArrayList<Integer>> result;

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		result = new ArrayList<ArrayList<Integer>>();
		traverse(root, sum, new ArrayList<Integer>(), 0);
		return result;
	}

	private void traverse(TreeNode node, int sum, ArrayList<Integer> path,
			int subsum) {
		if (node == null) {
			return;
		}
		int v = node.val;
		path.add(v);
		subsum += v;
		if (sum == subsum && node.left == null && node.right == null) {
			result.add(path);
			return;
		}
		if (node.left != null)
			traverse(node.left, sum, (ArrayList<Integer>) path.clone(), subsum);
		if (node.right != null)
			traverse(node.right, sum, (ArrayList<Integer>) path.clone(), subsum);
	}
}
