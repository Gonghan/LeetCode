package February;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrder {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		queue.offer(root);

		while (queue.peek() != null) {
			ArrayList<Integer> tmplist = new ArrayList<Integer>();
			Queue<TreeNode> tmpqueue = new LinkedList<TreeNode>();
			while (queue.peek() != null) {
				TreeNode tmpnode = queue.poll();
				tmpqueue.offer(tmpnode);
			}
			while (tmpqueue.peek() != null) {
				TreeNode tmpnode = tmpqueue.poll();
				tmplist.add(tmpnode.val);
				if (tmpnode.left != null) {
					queue.add(tmpnode.left);
				}
				if (tmpnode.right != null) {
					queue.add(tmpnode.right);
				}
			}
			result.add(tmplist);
		}
		return result;
	}
}
