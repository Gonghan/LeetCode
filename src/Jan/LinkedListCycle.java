package Jan;

import Nov.ListNode;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode first=head;
        ListNode second=head;
        while(second.next!=null && second.next.next!=null){
            if(first.next==second.next.next){
                return true;
            }else{
                first=first.next;
                second=second.next.next;
            }
        }
        
        return false;
    }
}
