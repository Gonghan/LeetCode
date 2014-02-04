package Jan;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	public static void main(String args[]) {
		Subsets s = new Subsets();
		int S[] = { 0 };
		System.out.print(s.subsets(S).size());
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = null;
		if (S == null || S.length == 0) {
			return result;
		}
		Arrays.sort(S);

		result = build(S);
		result.add(new ArrayList<Integer>());
		return result;
	}

	private ArrayList<ArrayList<Integer>> build(int[] S) {
		if (S.length == 0) {
			return null;
		}
		int first = S[0];
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp1 = new ArrayList<Integer>();
		tmp1.add(first);
		result.add(tmp1);
		int[] newS = Arrays.copyOfRange(S, 1, S.length);
		ArrayList<ArrayList<Integer>> nextLevel = build(newS);
		if (nextLevel == null) {
			return result;
		}

		for (ArrayList<Integer> tmpList : nextLevel) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.add(first);
			for (Integer i : tmpList) {
				newList.add(i);
			}
			result.add(newList);
			result.add(tmpList);
		}
		return result;
	}
}
