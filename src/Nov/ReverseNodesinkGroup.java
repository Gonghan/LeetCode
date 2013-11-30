package Nov;

public class ReverseNodesinkGroup {

	public static void main(String[] args) {
		ReverseNodesinkGroupSolution s=new ReverseNodesinkGroupSolution();
		myListNode a1=new myListNode(2);
		myListNode a2=new myListNode(1);
		myListNode a3=new myListNode(3);
		myListNode a4=new myListNode(4);
		a1.next=a2;
		a2.next=a3;
		a3.next=a4;
		s.reverseKGroup(a1, 2);

	}

}

// Definition for singly-linked list.
class myListNode {
	int val;
	myListNode next;

	myListNode(int x) {
		val = x;
		next = null;
	}
}

class ReverseNodesinkGroupSolution {
	public myListNode reverseKGroup(myListNode head, int k) {
		if(k<=1){
            return head;
        }
        myListNode newHead=null;
        myListNode tmp=null;
        boolean ifContinue=true;
        while(ifContinue){
            tmp=head;
            for(int i=0;i<k;i++){
                if(tmp==null){
                    if(newHead==null){
                        return head;
                    }
                    else{
                        ifContinue=false;
                        break;
                    }
                }
                tmp=tmp.next;
            }
            if(ifContinue==false){
                break;
            }
            myListNode first=head;
            myListNode second=first.next;
            for(int i=0;i<k-1;i++){
                myListNode newfirst=second;
                myListNode newsecond=second.next;
                second.next = first;
			    first = newfirst;
			    second = newsecond;
            }
            myListNode tail=first;
            head.next=second;
            if(newHead==null){
                newHead=tail;
            }
            head=head.next;
        }
        
        
        return newHead;
	}

	
}