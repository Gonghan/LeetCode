package February;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {

	public static void main(String args[]) {
		CombinationSumII c = new CombinationSumII();
		int[] num = {1};
		int target = 1;
		System.out.println(c.combinationSum2(num, target));
	}

	private ArrayList<ArrayList<Integer>> result;

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		result = new ArrayList<ArrayList<Integer>>();
		combine(0, num, target, new ArrayList<Integer>(), 0);
		return result;
	}

	private void combine(int index, int[] num, int target,
			ArrayList<Integer> path, int subsum) {
		int len = num.length;
		if (subsum == target) {
			result.add(path);
			return;
		}
		if (index >= len || subsum > target) {
			return;
		}
		for (int i = index; i < len;) {
			int c = 1;
			int value = num[i];
			// c counts how many num[i] here
			while (i + c < len && value == num[i + c]) {
				c++;
			}
			for (int j = 1; j <= c; j++) {
				ArrayList<Integer> tmppath = (ArrayList<Integer>) path.clone();
				for (int k = 0; k < j; k++) {
					tmppath.add(value);
				}
				combine(i + c, num, target, tmppath, subsum + value * j);
			}
			i = i + c;
		}
	}
}
