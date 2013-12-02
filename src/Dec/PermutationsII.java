package Dec;

import java.util.ArrayList;

public class PermutationsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationsIISolution s=new PermutationsIISolution();
		int[]num={1,1,2};
		ArrayList<ArrayList<Integer>>result=s.permuteUnique(num);
		System.out.println(result);

	}

}

class PermutationsIISolution {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// int []newNum =Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int[] used = new int[num.length];
		for (int i = 0; i < used.length; i++) {
			used[i] = 0;
		}
		permuteUnique(num, used, new ArrayList<Integer>(), result);
		return result;
	}

	private void permuteUnique(int[] num, int[] used,
			ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
		if (current.size() == num.length) {
			result.add(current);
			return;
		}
		// find first unused and and not used for this bit
		int[] newNum = cloneIntArray(num);
		int[] newUsed = cloneIntArray(used);

		ArrayList<Integer> usedInThisBit = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (newUsed[i] == 0 && !usedInThisBit.contains(newNum[i])) {
				ArrayList<Integer> newCurrent = new ArrayList<Integer>();
				for (Integer j : current) {
					newCurrent.add(j);
				}
				newCurrent.add(newNum[i]);
				usedInThisBit.add(newNum[i]);
				newUsed[i] = 1;
				permuteUnique(newNum, newUsed, newCurrent, result);
				newUsed[i] = 0;
			}
		}
	}

	private int[] cloneIntArray(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		return b;
	}
}