package February;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {

	public static void main(String args[]) {
		int num[] = { -3,-2,-1,0,0,1,2,3};
		int target = 0;
		System.out.println(new FourSum().fourSum(num, target));
	}

	// Time limit exceeds.
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < num.length; j++) {
				if (j != i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				//find last two numbers from num[j+1, end]
				int k=j+1;
				int l=num.length-1;
				int subsum=num[i]+num[j];
				while(k<l){
					if(k!=j+1 && num[k]==num[k-1]){
				        k++;
				        continue;
				    }
				    if(l!=num.length-1 && num[l]==num[l+1]){
				        l--;
				        continue;
				    }
					int newsub=subsum+num[k]+num[l];
					if(newsub==target){
						ArrayList<Integer>tmpList=new ArrayList<Integer>();
						tmpList.add(num[i]);
						tmpList.add(num[j]);
						tmpList.add(num[k]);
						tmpList.add(num[l]);
						result.add(tmpList);
						//break;
					}
					if(newsub<target){
						k++;
					}else{
						l--;
					}
				}
			}
		}
		return result;
	}
}
