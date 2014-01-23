package Jan;

public class populatingNextRightPointer {

	/**
	 * Definition for binary tree with next pointer.
	 */
	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode tmp = root;
		while (tmp.left != null) {
			// TreeLinkNode current=null;
			TreeLinkNode previous = null;
			for (TreeLinkNode i = tmp; i != null; i = i.next) {
				if (previous == null) {
					previous = i.right;
					i.left.next = i.right;
				} else {
					previous.next = i.left;
					i.left.next = i.right;
					previous = i.right;
				}

			}
			tmp = tmp.left;
		}
	}

}
