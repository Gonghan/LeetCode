package February;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrdering {

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Queue<TreeNode> newqueue = new LinkedList<TreeNode>();
			ArrayList<Integer> tmplist = new ArrayList<Integer>();
			while (!queue.isEmpty()) {
				TreeNode tmp = queue.poll();
				tmplist.add(tmp.val);
				if (tmp.left != null) {
					newqueue.add(tmp.left);
				}
				if (tmp.right !=null) {
					newqueue.add(tmp.right);
				}
			}
			result.add(0, tmplist);
			queue = newqueue;
		}
		return result;
	}
}
