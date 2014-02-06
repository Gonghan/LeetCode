package February;

import java.util.ArrayList;

/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {

	public static void main(String args[]) {
		Triangle t = new Triangle();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add(1);
		b.add(2);
		b.add(3);
		list.add(a);
		list.add(b);
		int i=t.minimumTotal(list);
		System.out.println(i);
	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle.isEmpty()) {
			return 0;
		}
		int len = triangle.size();
		int[] level = new int[len];
		int[] tmplevel = new int[len];
		for (int i = 0; i < len; i++) {
			ArrayList<Integer> tmp = triangle.get(i);
			if (i == 0) {
				level[0] = tmp.get(0);
				continue;
			}
			for (int j = 0; j < tmp.size(); j++) {
				tmplevel[j] = getNew(level, j, i) + tmp.get(j);
			}
			int[] exchange = tmplevel;
			tmplevel = level;
			level = exchange;
		}
		int min = Integer.MAX_VALUE;
		for (int i : level) {
			min = Math.min(min, i);
		}
		return min;
	}

	private int getNew(int[] level, int j, int i) {
		if (j == 0) {
			return level[j];
		}
		if (j == i) {
			return level[i - 1];
		}
		return Math.min(level[j], level[j - 1]);
	}
}
