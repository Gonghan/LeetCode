package February;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class SubsetsII {
	
	public static void main(String args[]) {
		SubsetsII s=new SubsetsII();
		int num[]={1,1,2,2};
		System.out.println(s.subsetsWithDup(num));
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		Arrays.sort(num);
		result = process(0, num);
		return result;
	}

	private ArrayList<ArrayList<Integer>> process(int index, int num[]) {
		ArrayList<ArrayList<Integer>> superlist = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmplist = new ArrayList<Integer>();
		superlist.add(tmplist);
		if (index >= num.length) {
			return superlist;
		}

		int tmpindex = index;
		while (tmpindex < num.length && num[tmpindex] == num[index]) {
			@SuppressWarnings("unchecked")
			ArrayList<Integer> tmplist2 = (ArrayList<Integer>) tmplist.clone();
			tmplist2.add(num[index]);
			superlist.add(tmplist2);
			tmpindex++;
			tmplist = tmplist2;
		}
		ArrayList<ArrayList<Integer>> nextsuperlist = process(tmpindex, num);
		if (nextsuperlist == null) {
			return superlist;
		}
		ArrayList<ArrayList<Integer>> resultsuperlist = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> a : superlist) {
			for (ArrayList<Integer> b : nextsuperlist) {
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.addAll(a);
				tmp.addAll(b);
				resultsuperlist.add(tmp);
			}
		}
		return resultsuperlist;
	}

}
