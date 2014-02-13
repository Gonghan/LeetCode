package February;

import Nov.ListNode;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */

public class RemoveNthNodes {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tmp1 = head;
		ListNode tmp2 = head;
		int pos = 0;
		while (tmp1 != null) {
			if (pos >= n) {
				tmp2 = tmp2.next;
			}
			pos++;
			tmp1 = tmp1.next;
		}
		if (tmp2 == head) {
			return head.next;
		}
		if (tmp2.next != null) {
			tmp2.next = tmp2.next.next;
		}
		return head;
	}
}
