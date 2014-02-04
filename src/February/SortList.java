package February;

import java.util.ArrayList;
import java.util.Collections;

import Nov.ListNode;

/*
 * 
 * http://oj.leetcode.com/problems/sort-list/
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {

	public ListNode sortList(ListNode head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode tmp = head;
		while (tmp != null) {
			list.add(tmp.val);
			tmp = tmp.next;
		}
		Collections.sort(list);
		ListNode newhead = null;
		tmp = newhead;
		for (Integer i : list) {

			if (newhead == null) {
				tmp = new ListNode(i);
				newhead = tmp;
				// tmp=tmp.next;
				continue;
			}
			tmp.next = new ListNode(i);
			tmp = tmp.next;
		}
		return newhead;
	}
}
