package Jan;

import java.util.HashMap;

public class Candy {

	HashMap<Integer, Integer> map;

	public int candy(int[]A){
		int result=0;
		int length=A.length;
		//record how many values are smaller than the current one before and after that node
		HashMap<Integer, Integer> map_left=new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map_right=new HashMap<Integer, Integer>();
		for(int i=0;i<length;i++){
			map_left.put(i, 0);
			map_right.put(i, 0);
		}
		map_left.put(0, 0);
		map_right.put(length-1, 0);
		for(int i=1;i<length;i++){
			int j=length-1-i;//reversed
			if(A[i]>A[i-1]){
				map_left.put(i, map_left.get(i-1)+1);
			}
			if(A[j]>A[j+1]){
				map_right.put(j, map_right.get(j+1)+1);
			}
		}
		for(int i=0;i<length;i++){
			result=Math.max(map_left.get(i),map_right.get(i))+result;
		}
		return result+length;
	}
	
	public int candy2(int[] A) {
		map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			map.put(i, 0);
		}

		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				map.put(i, 1);
				continue;
			}
			if (A[i] < A[i - 1]) {
				map.put(i,1);
				if (map.get(i - 1) == 1) {
					// cause a conflict
					for(int j=i-1;j>=0;j--){
						boolean conflict=checkConflict(A,j);
						if(!conflict){
							break;
						}
						map.put(j, map.get(j+1)+1);
					}
				}
				continue;
			}
			if(A[i]==A[i-1]){
				map.put(i, 1);
				continue;
			}
			if(A[i]>A[i-1]){
				map.put(i,map.get(i-1)+1);
				continue;
			}
			
		}
		int sum=0;
		for(int i=0;i<A.length;i++){
			sum+=map.get(i);
		}
		return sum;
	}

	public boolean checkConflict(int[] A, int index) {
		boolean result = false;

		if (A.length <= 1) {
			return false;
		}
		if (index != A.length - 1) {
			if (A[index] > A[index + 1]) {
				boolean tmp = map.get(index) <= map.get(index + 1);
				result = tmp || result;
			}

			if (A[index] < A[index + 1]) {
				boolean tmp = map.get(index) >= map.get(index + 1);
				result = tmp || result;
			}
		}
		if (index != 0) {
			if (A[index] > A[index - 1]) {
				boolean tmp = map.get(index) <= map.get(index - 1);
				result = tmp || result;
			}

			if (A[index] < A[index - 1]) {
				boolean tmp = map.get(index) >= map.get(index - 1);
				result = tmp || result;
			}
		}
		return result;
	}
	
	public static void main(String args[]){
		Candy candy=new Candy();
		int[] A={5,2,9,12,7,4};
		int result=candy.candy(A);
		System.out.println(result);
	}
}
