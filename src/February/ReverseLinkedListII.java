package February;

import Nov.ListNode;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ¡Ü m ¡Ü n ¡Ü length of list.
 */
public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = new ListNode(0);
		prev.next = head;
		head = prev;
		ListNode n1 = head;
		int k = m - 1;
		while (k > 0) {
			n1 = n1.next;
			k--;
		}

		prev = n1;
		n1 = n1.next;
		k = n - m;
		while (n1.next != null && k > 0) {
			ListNode temp = n1.next;
			n1.next = temp.next;
			temp.next = prev.next;
			prev.next = temp;
			k--;
		}
		return head.next;
	}
}
