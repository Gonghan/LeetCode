package Nov;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

	public static void main(String args[]) {
		ThreeSumSolution s = new ThreeSumSolution();
		int num[] = {1,1, 1, 2, -2, -1 };
		ArrayList<ArrayList<Integer>> result = s.threeSum(num);
		System.out.println(result);
	}
}

class ThreeSumSolution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3) {
			return result;
		}
		// sort this array
		Arrays.sort(num);

		// sum of first two must be not greater than 0
		for (int i = 0; i < num.length - 2; i++) {
			if (num[i] > 0) {
				break;
			}
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < num.length - 1; j++) {
				if (num[i] + num[j] > 0) {
					break;
				}
				if (j != i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				int last = 0 - num[i] - num[j];
				if (has(j + 1, last, num)) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[j]);
					tmp.add(last);
					result.add(tmp);
				}
			}
		}
		return result;
	}

	private boolean has(int begin_index, int value, int[] num) {
		for (int i = begin_index; i < num.length; i++) {
			if (num[i] == value) {
				return true;
			}
		}
		return false;
	}
}