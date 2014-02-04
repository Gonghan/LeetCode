package Jan;

import java.util.ArrayList;

import Nov.ListNode;

public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		ListNode newHead = head;
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		ListNode tmp = head;
		while (tmp != null) {
			list.add(tmp);
			tmp = tmp.next;
		}
		for (ListNode node : list) {
			if (node == head) {
				node.next = null;
				continue;
			}
			if (node.val < newHead.val) {
				node.next = newHead;
				newHead = node;
				continue;
			}
			ListNode t = newHead;
			while (true) {
				if (t.next == null) {
					t.next = node;
					node.next = null;
					t = t.next;
					break;
				}
				if (node.val < t.next.val) {
					node.next = t.next;
					t.next = node;
					t = t.next;
					break;
				}
				t = t.next;
			}
		}
		return newHead;
	}
}
