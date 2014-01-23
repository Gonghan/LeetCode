package Jan;

import java.util.HashSet;
import java.util.Set;

import Nov.ListNode;

public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
        Set<Integer>elements=new HashSet<Integer>();
        ListNode node=head;
        if(head==null){
            return head;
        }
        elements.add(head.val);
        node=head.next;
        ListNode previous=head;
        while(true){
            if(node==null){
                break;
            }
            if(isDuplicate(node,elements)){
                previous.next=node.next;
            }else{
                previous=node;
            }
            node=node.next;
            
        }
        return head;
    }
    
    private boolean isDuplicate(ListNode node,Set<Integer>set){
        if(node==null){
            return false;
        }
        if(set.contains(node.val)){
            return true;
        }else{
            set.add(node.val);
            return false;
        }
    }
}
