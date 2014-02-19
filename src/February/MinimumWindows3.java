package February;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindows3 {

	public static void main(String args[]) {
		MinimumWindows3 m = new MinimumWindows3();
		System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
	}

	public String minWindow(String S, String T) {
		if (S.isEmpty() || T.isEmpty()) {
			return "";
		}
		String result = "";
		Map<Character, Integer> tmap = new HashMap<>();
		Map<Character, Integer> currmap = new HashMap<>();
		char[] cht = T.toCharArray();
		char[] chs = S.toCharArray();
		for (char c : cht) {
			currmap.put(c, 0);
			if (tmap.containsKey(c)) {
				tmap.put(c, tmap.get(c) + 1);
			} else {
				tmap.put(c, 1);
			}
		}
		Map<Character, Integer> remain = new HashMap<>(tmap);
		int low = 0;
		int high = 0;
		while (high < chs.length) {
			boolean hasFound = remain.isEmpty();
			if (!hasFound) {
				if (remain.containsKey(chs[high])) {
					int counter = remain.get(chs[high]);
					if (counter <= 1) {
						remain.remove(chs[high]);
					} else {
						remain.put(chs[high], counter - 1);
					}
				}
				if (currmap.containsKey(chs[high])) {
					currmap.put(chs[high], currmap.get(chs[high]) + 1);
				}
				if (remain.isEmpty()) {
					result = S.substring(low, high + 1);
					continue;
				}
				high++;
			} else {
				// move low first
				while (low <= high) {
					if (currmap.containsKey(chs[low])) {
						int currcounter = currmap.get(chs[low]);
						int tmapcounter = tmap.get(chs[low]);
						if (currcounter <= tmapcounter) {
							break;
						} else if (currcounter > tmapcounter) {
							currmap.put(chs[low], currcounter - 1);
						}
					}
					low++;
					if (high - low + 1 < result.length()) {
						result = S.substring(low, high + 1);
					}
				}
				// move high
				high++;
				if (high >= S.length()) {
					break;
				}
				if (currmap.containsKey(chs[high])) {
					currmap.put(chs[high], currmap.get(chs[high]) + 1);
				}
			}
		}
		return result;
	}
}
