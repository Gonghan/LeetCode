package Jan;

import java.util.ArrayList;

import Nov.ListNode;

public class MergeKSortedLists {
	
	public static void main(String args[]){
		ArrayList<ListNode>lists=new ArrayList<ListNode>();
		ListNode node=new ListNode(1);
		lists.add(node);
		MergeKSortedLists m=new MergeKSortedLists();
		ListNode n=m.mergeKLists(lists);
		System.out.println(n.val);
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		ListNode root = new ListNode(0);
		ListNode now = root;
		// init the current nodes of all lists
		ArrayList<ListNode> currentNodes = new ArrayList<ListNode>();
		for (ListNode node : lists) {
			currentNodes.add(node);
		}

		while (true) {
			// ending condition
			boolean end = true;
			for (ListNode tmp : currentNodes) {
				if (tmp != null) {
					end = false;
				}
			}
			if (end == true) {
				return root.next;
			}

			// find smallest
			for (ListNode tmp : currentNodes) {
				if (tmp == null) {
					continue;
				}
				if (now.next == null) {
					now.next = tmp;
					continue;
				}
				if (tmp.val < now.next.val) {
					now.next = tmp;
				}
			}
			currentNodes.set(currentNodes.indexOf(now.next), now.next.next);
			now=now.next;
		}
		// return root.next;
	}
}
