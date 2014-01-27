package Jan;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {
	
	public static void main(String arsgs[]){
		CombinationSum c=new CombinationSum();
		int candidates[]={1,2};
		System.out.println(c.combinationSum(candidates, 4));
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>list=new ArrayList<Integer>();
        for(int i:candidates){
            if(i>target){
                continue;
            }
            if(!list.contains(i)){
                list.add(i);
            }
        }
        if(list.size()==0){
        	return result;
        }
        Collections.sort(list);
        combine(list,target,result,new ArrayList<Integer>(),-1);
        return result;
    }

	// tmp records the path passed
	private void combine(ArrayList<Integer> list, int target,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp,
			int previous) {
		int sum = getSum(tmp);
		if (sum > target) {
			return;
		}
		if (sum == target) {
			result.add(tmp);
			return;
		}
		// decide which number to begin with
		// previous=-1=>begin with the first one
		int current = previous + 1;
		if(current>=list.size()){
		    return;
		}
		int newV = list.get(current);
		for (int i = 0; sum + i * newV <= target; i++) {
			ArrayList<Integer> newTmp = new ArrayList<Integer>();
			for (Integer integer : tmp) {
				newTmp.add(integer);
			}
			for (int j = 1; j <= i; j++) {
				newTmp.add(newV);
			}
			combine(list, target, result, newTmp, current);
		}

	}

	private int getSum(ArrayList<Integer> tmp) {
		int sum = 0;
		for (Integer i : tmp) {
			sum += i;
		}
		return sum;
	}
}
