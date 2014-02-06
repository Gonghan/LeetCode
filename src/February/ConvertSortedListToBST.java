package February;

import java.util.ArrayList;
import java.util.Arrays;

import Nov.ListNode;

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListToBST {

	public TreeNode sortedListToBST(ListNode head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode tmp = head;
		while (tmp != null) {
			list.add(tmp.val);
			tmp = tmp.next;
		}
		TreeNode root = null;
		Integer[] array = list.toArray(new Integer[list.size()]);
		root = process(root, array);
		return root;
	}

	private TreeNode process(TreeNode node, Integer[] array) {
		int len = array.length;
		if (len == 0) {
			return null;
		}
		if (node == null) {
			node = new TreeNode(array[len / 2]);
			node.left = process(node.left,
					Arrays.copyOfRange(array, 0, len / 2));
			node.right = process(node.right,
					Arrays.copyOfRange(array, len / 2 + 1, len));
		}
		return node;
	}
}
