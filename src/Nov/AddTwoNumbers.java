package Nov;

public class AddTwoNumbers {

	
	public static void main(String[] args) {
		AddTwoNumbersSolution s=new AddTwoNumbersSolution();
		ListNode l1=new ListNode(5);
		ListNode l2=new ListNode(5);
		ListNode result=s.addTwoNumbers(l1, l2);
		System.out.println(result.val);
	}

}


class AddTwoNumbersSolution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode tmp = result;

		if (l1 == null || l2 == null) {
			return null;
		}
		// Create two pointers of two nodes,
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		int counter = 0;
		while (tmp1 != null || tmp2 != null || counter != 0) {
			int v1 = 0;
			int v2 = 0;
			if (tmp1 != null) {
				v1 = tmp1.val;
				tmp1 = tmp1.next;
			}
			if (tmp2 != null) {
				v2 = tmp2.val;
				tmp2 = tmp2.next;
			}
			int value = v1 + v2 + counter;
			if (value >= 10) {
				value = value - 10;
				counter = 1;
			} else {
				counter = 0;
			}

			if(result==null){
				result=new ListNode(value);
				tmp=result;
				continue;
			}
			tmp.next = new ListNode(value);
			tmp=tmp.next;

		}
		return result;

	}
}