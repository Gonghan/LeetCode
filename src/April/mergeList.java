package April;

public class mergeList {

	
	public ListNode sortList(ListNode head) {
		if(head==null || head.next==null){
			return head;
		}
		ListNode p=head;
		ListNode l=head;
		ListNode r=null;
		int len=0;
		while(p!=null){
			len++;
			p=p.next;
		}
		int mid=len/2;
		p=head;
		int index=0;
		while(true){
			index++;
			p=p.next;
			if(index==mid){
				ListNode next=p.next;
				p.next=null;
				r=next;
				break;
			}
		}
		ListNode h1=sortList(l);
		ListNode h2=sortList(r);
		head=merge(h1,h2);
		return head;
    }
	private ListNode merge(ListNode l,ListNode r){
		ListNode newHead=new ListNode(-1);//fake head
		ListNode p=newHead;
		ListNode p1=l;
		ListNode p2=r;
		while(p1!=null || p2!=null){
			if(p1==null){
				p.next=p2;
				p2=p2.next;
				p=p.next;
			}else if(p2==null){
				p.next=p1;
				p1=p1.next;
				p=p.next;
			}else{
				if(p1.val<p2.val){
					p.next=p1;
					p1=p1.next;
					p=p.next;
				}else{
					p.next=p2;
					p2=p2.next;
					p=p.next;
				}
			}
		}
		
		return newHead.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
