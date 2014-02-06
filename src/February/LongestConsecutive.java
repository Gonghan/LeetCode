package February;

import java.util.HashMap;

public class LongestConsecutive {
	
	public static void main(String args[]){
		LongestConsecutive l=new LongestConsecutive();
		int num[]={1,3,5};
		System.out.println(l.longestConsecutive(num));
	}

	public int longestConsecutive(int[] num) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : num) {
			map.put(i, 0);
		}
		for (int i : num) {
			map.put(i, get(i, map));
		}
		int max = 0;
		for (int i : num) {
			int v = map.get(i);
			if (v > max) {
				max = v;
			}
		}
		return max;
	}

	int get(int v, HashMap<Integer, Integer> map) {
		if (map.containsKey(v)) {
			int newv = map.get(v);
			if (newv != 0) {
				return newv;
			} else {
				int tmp = 1 + get(v + 1, map);
				map.put(v, tmp);
				return tmp;
			}

		}
		return 0;
	}

}
