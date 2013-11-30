package Nov;

/*
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Follow up:
 Can you solve it without using extra space?
 */

public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class LinkedListCycleIISolution {
	public ListNode detectCycle(ListNode head) {
		// set two pointers
		// phase I:
		// first: one step each time
		// second: two steps each time
		// if first==second, cycle found
		// if second or second.next ==null, no cycle

		// phase II:
		// continue the first phase, set a counter
		// when meeting the second time, counter==loop size

		// phase III:
		// first=head, second=head+loop size
		// both walk one step each time
		// when meeting, got the result

		ListNode first = head;
		ListNode second = head;
		int nthmeeting = 0;
		int loopsize = 0;
		while (second != null && second.next != null) {
			first = first.next;
			second = second.next.next;
			if (nthmeeting == 1) {
				loopsize++;
			}
			if (first == second) {
				if (nthmeeting == 0) {
					nthmeeting = 1;
				} else {
					break;
				}
			}
		}
		if (second == null || second.next == null) {
			return null;
		}
		first = head;
		second = head;
		for (int i = 0; i < loopsize; i++) {
			second = second.next;
		}
		while (second != null) {
			if (first == second) {
				return first;
			}
			first = first.next;
			second = second.next;

		}
		return null;
	}

}