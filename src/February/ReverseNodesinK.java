package February;

import java.util.ArrayList;

import Nov.ListNode;

public class ReverseNodesinK {
	
	public static void main(String args[]){
		System.out.println(new ReverseNodesinK().reverseKGroup(null, 2));
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1) {
			return head;
		}
		ArrayList<Integer> list = new ArrayList<>();
		ListNode tmp = head;
		while (tmp != null) {
			//list.add(tmp);
			tmp = tmp.next;
		}
		ListNode fake = new ListNode(-1);
		tmp = fake;
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			int base = (i / k) * k;
			if (base + k > size) {
				break;
			}
			int newindex = k - i - 1 + 2* base;
			System.out.println(newindex);
//			ListNode node = list.get(newindex);
//			node.next = null;
//			tmp.next = node;
//			tmp = tmp.next;
		}
		return fake.next;
	}
}
