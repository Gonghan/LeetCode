package Jan;

import java.util.ArrayList;
import java.util.HashMap;

import Nov.ListNode;

public class ReorderList {
	public static void main(String args[]){
		ListNode A=new ListNode(1);
		ListNode B=new ListNode(2);
		ListNode C=new ListNode(3);
		A.next=B;
		B.next=C;
		ReorderList r=new ReorderList();
		r.reorderList(A);
	}

	public void reorderList(ListNode head) {
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		HashMap<ListNode, Boolean> visited = new HashMap<ListNode, Boolean>();
		ListNode t = head;
		while (t != null) {
			list.add(t);
			visited.put(t, false);
			t=t.next;
		}
		int len = list.size();
		ListNode previous = null;
		if (len == 0 || len == 1) {
			return;
		}
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				// head..
				ListNode tmp = list.get(len - i - 1);
				head.next = tmp;
				tmp.next = null;
				previous = tmp;
				visited.put(head, true);
				visited.put(tmp, true);
				continue;
			}
			ListNode tmp1 = list.get(i);
			ListNode tmp2 = list.get(len - i - 1);
			if (visited.get(tmp2) == true || visited.get(tmp1) == true) {
				break;
			}
			previous.next = tmp1;
			tmp1.next = tmp2;
			previous = tmp2;
			visited.put(tmp1, true);
			visited.put(tmp2, true);
		}
	}
}
