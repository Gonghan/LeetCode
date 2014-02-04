package Jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {

	public ArrayList<String> anagrams(String[] strs) {
		HashMap<Double, ArrayList<String>> map = new HashMap<Double, ArrayList<String>>();
		ArrayList<String> result = new ArrayList<String>();
		for (String s : strs) {
			double d = getCode(s);
			if (map.containsKey(d) == false) {
				ArrayList<String> tmp = new ArrayList<String>();
				tmp.add(s);
				map.put(d, tmp);
			} else {
				ArrayList<String> tmp = map.get(d);
				tmp.add(s);
				map.put(d, tmp);
			}
		}
		for (double d : map.keySet()) {
			ArrayList<String> tmp = map.get(d);
			if (tmp.size() >= 2) {
				result.addAll(tmp);
			}
		}
		return result;
	}

	private double getCode(String s) {
		double d = 0;
		char[] tmp = s.toCharArray();
		Arrays.sort(tmp);
		for (char c : tmp) {
			d = d * 27 + (c - 'a' + 1);
		}
		return d;
	}

}
