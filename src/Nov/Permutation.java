package Nov;

import java.util.ArrayList;

public class Permutation {
	public static void main(String args[]){
		PermutationSolution s=new PermutationSolution();
		int num[]={1,2,3};
		System.out.println(s.permute(num));
	}

}
class PermutationSolution {
    //tests
    //[1]=>[[1]]
    //[]=>[]
    //[1,2,3]
    //[1,1,2]=>[[1,1,2],[1,2,1],[2,1,1]]
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(num==null){
            return result;
        }
        permute(num,new ArrayList<Integer>(),result);
        return result;
    }
    
    // remaining= the integers not used
    // current_permutation= the collection from the previous calling
    // result a list to add into
    // if current=previous && current!=first, do nothing and go next
    private void permute(int [] remaining,ArrayList<Integer> current_permutation,ArrayList<ArrayList<Integer>>result){
        if(remaining.length==0){
            result.add(current_permutation);
            return;
        }
        if(remaining.length==1){
            current_permutation.add(remaining[0]);
            result.add(current_permutation);
            return;
        }
        for(int i=0;i<remaining.length;i++){
            int value=remaining[i];
            if(i!=0 && remaining[i]==remaining[i-1]){
                continue;
            }
            //copy the current permutation into the new one
            ArrayList<Integer> new_current_permutation=new ArrayList<Integer>();
            for(Integer integer:current_permutation){
                new_current_permutation.add(integer);
            }
            new_current_permutation.add(value);
            int [] new_remaining=new int[remaining.length-1];
            //copy the remaining into new_remaining
            int new_index=0;
            for(int j=0;j<remaining.length;j++){
                
                if(i!=j){
                    new_remaining[new_index]=remaining[j];
                    new_index++;
                }
                
            }
            permute(new_remaining,new_current_permutation,result);
        }
        
    }
}