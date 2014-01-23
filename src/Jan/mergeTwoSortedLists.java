package Jan;

import Nov.ListNode;

public class mergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first=l1;
        ListNode second=l2;
        //this is an empty node
        ListNode root=new ListNode(0);
        ListNode tmp=root;
        //check nulls
        while(true){
            if(first==null && second==null){
                return root.next;
            }
            if(first==null){
                tmp.next=second;
                return root.next;
            }
            if(second==null){
                tmp.next=first;
                return root.next;
            }
            if(first.val<second.val){
                tmp.next=first;
                first=first.next;
            }else{
                tmp.next=second;
                second=second.next;
            }
            tmp=tmp.next;
            
        }
        //return root.next;
    }
}
