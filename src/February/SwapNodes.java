package February;

import Nov.ListNode;

public class SwapNodes {

	/*
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 */
	
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newhead = head.next;
		head.next = newhead.next;
		newhead.next = head;
		ListNode tmp = head;
		while (tmp != null && tmp.next != null && tmp.next.next != null) {
			ListNode first = tmp.next;
			ListNode second = first.next;
			tmp.next = second;
			first.next = second.next;
			second.next = first;
			tmp = first;
		}
		return newhead;
	}
}
