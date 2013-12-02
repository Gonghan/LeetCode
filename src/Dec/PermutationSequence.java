package Dec;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationSequenceSolution s=new PermutationSequenceSolution();
		System.out.println(s.getPermutation(2, 1));
	}

}

class PermutationSequenceSolution {
    public String getPermutation(int n, int k) {
        //guess the first number
        //guess the seecond number
        //...
        //create a array all 1!, 2!, .., n!
        String result="";
        HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
        map.put(0,1);
        for(int i=1;i<n;i++){
            int previous=map.get(i-1);
            map.put(i,i*previous);
        }
        ArrayList<Integer> remain=new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            remain.add(i);
        }
        
        for(int i=1;i<=n;i++){
            int nthInRemain=(k-1)/map.get(n-i);
            int value=remain.get(nthInRemain);
            remain.remove(nthInRemain);
            k=k-nthInRemain*map.get(n-i);
            result+=value;
        }
        return result;
        
    }
}