package February;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import Nov.ListNode;

/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */
public class RemoveSortedListII {

	public static void main(String argsp[]) {
		ListNode A = new ListNode(1);
		ListNode B = new ListNode(1);
		ListNode C = new ListNode(21);
		ListNode D = new ListNode(5);
		ListNode E = new ListNode(5);
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		RemoveSortedListII r = new RemoveSortedListII();
		ListNode n = r.deleteDuplicates(A);
		System.out.println(n);

	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode tmp = head;
		Set<Integer> set = new HashSet<Integer>();
		while (tmp != null && tmp.next != null) {
			if (tmp.val == tmp.next.val) {
				set.add(tmp.val);
			}
			tmp = tmp.next;
		}
//		if (tmp!=null && !set.contains(tmp.val)) {
//			set.add(tmp.val);
//		}
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		tmp = head;
		while (tmp != null) {
			if (!set.contains(tmp.val)) {
				list.add(tmp);
			}
			tmp = tmp.next;
		}
		ListNode newhead = null;
		ListNode newtmp = newhead;
		for (int i = 0; i < list.size(); i++) {
			ListNode tmp2 = list.get(i);
			if (i == 0) {
				newhead = tmp2;
				newtmp = newhead;
				newtmp.next=null;
				continue;
			}
			newtmp.next = tmp2;
			newtmp = tmp2;
			newtmp.next = null;
		}
		return newhead;
	}
}
