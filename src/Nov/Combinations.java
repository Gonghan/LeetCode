package Nov;

import java.util.ArrayList;

public class Combinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
class CombinationsSolution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        //bad cases
        if(n<k){
            return null;
        }
        if(n==0){
            return null;
        }
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        combine(n,k,new ArrayList<Integer>(),result);
        return result;
    }
    
    private void combine(int n,int k,ArrayList<Integer> tmp,ArrayList<ArrayList<Integer>> result){
        if(k==0){
            result.add(tmp);
            return;
        }
        int next=0;
        int last=0;
        if (!tmp.isEmpty()){
            last=tmp.get(tmp.size()-1);
            if(last>=n){
                return;
            }
        }
        next=last+1;
        for(int i=next;i<=n;i++){
            ArrayList<Integer> newList=new ArrayList<Integer>();
            for(Integer t: tmp){
                newList.add(t);
            }
            newList.add(i);
            combine(n,k-1,newList,result);
        }
    }
}