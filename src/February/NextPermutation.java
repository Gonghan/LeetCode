package February;

import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {
	public static void main(String args[]){
		NextPermutation n=new NextPermutation();
		int num[]={2,3,1};
		n.nextPermutation(num);
		for(int i:num)
			System.out.println(i);
	}

	public void nextPermutation(int[] num) {
        if(num==null || num.length<=1){
            return;
        }
        int len=num.length;
        ArrayList<Integer>tmplist=new ArrayList<Integer>();
        int index=len-1;
        int last=num[len-1];
        int tmpmax=last;
        while(index>=0){
            int curr=num[index];
            if(curr<tmpmax){
                //find the smallest one which is bigger than curr
                int smallest=0;
                for(int i=0;i<tmplist.size();i++){
                    if(tmplist.get(i)>curr && tmplist.get(i)<=tmpmax){
                        tmpmax=tmplist.get(i);
                        smallest=i;
                    }
                }
                num[index]=tmplist.get(smallest);
                tmplist.set(smallest,curr);
                Collections.sort(tmplist);
                for(int i=index+1;i<len;i++){
                    num[i]=tmplist.get(i-index-1);
                }
                return;
            }else{
            	tmpmax=curr;
            }
            tmplist.add(curr);
            index--;
        }
        Collections.sort(tmplist);
        for(int i=index+1;i<len;i++){
            num[i]=tmplist.get(i-index-1);
        }
    }
}
