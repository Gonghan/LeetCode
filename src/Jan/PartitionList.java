package Jan;

import Nov.ListNode;

public class PartitionList {

	public static void main(String args[]) {
		ListNode A = new ListNode(2);
		ListNode B = new ListNode(3);
		ListNode C = new ListNode(1);
		ListNode D = new ListNode(1);
		A.next = B;
		B.next = C;
		C.next = D;
		ListNode node = new PartitionList().partition(A, 2);
		System.out.println(node.val);
	}

	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;

		ListNode n1 = new ListNode(x - 1);
		n1.next = head;
		head = n1;

		while (n1 != null) {
			while (n1.next != null && n1.next.val < x)
				n1 = n1.next;
			if (n1.next == null)
				break;

			ListNode n2 = n1.next;
			while (n2.next != null && n2.next.val >= x)
				n2 = n2.next;
			if (n2.next == null)
				break;

			ListNode n3 = n2;
			while (n3.next != null && n3.next.val < x)
				n3 = n3.next;

			ListNode temp = n2.next;
			n2.next = n3.next;
			n3.next = n1.next;
			n1.next = temp;
		}

		head = head.next;
		return head;
	}
}
