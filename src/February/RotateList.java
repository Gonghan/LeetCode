package February;

import Nov.ListNode;

public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {
		if (n == 0) {
			return head;
		}
		int len = 0;
		ListNode tmp = head;
		ListNode tail = head;
		while (tmp != null) {
			tail = tmp;
			tmp = tmp.next;
			len++;
		}
		if (n >= len) {
			return head;
		}
		int newHeadIndex = 0;
		tmp = head;
		while (newHeadIndex != len - n - 1) {
			tmp = tmp.next;
			newHeadIndex++;
		}
		ListNode newHead = tmp.next;
		tmp.next = null;
		tail.next = head;
		return newHead;
	}
}
