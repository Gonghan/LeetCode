package February;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {

	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		if (root == null) {
			return;
		}
		queue.offer(root);
		while (queue.peek() != null) {
			Queue<TreeLinkNode> tmpqueue = new LinkedList<TreeLinkNode>();

			while (queue.peek() != null) {
				TreeLinkNode tmp = queue.poll();
				tmpqueue.offer(tmp);
			}
			TreeLinkNode prev = null;
			while (tmpqueue.peek() != null) {
				TreeLinkNode tmp = tmpqueue.poll();
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
				if (prev == null) {
					prev = tmp;
					continue;
				}
				prev.next = tmp;
				prev = tmp;
			}
		}
	}
}
