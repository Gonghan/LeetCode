package February;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindow {

	public static void main(String args[]) {
		MinimumWindow m = new MinimumWindow();
		System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
	}

	public String minWindow(String S, String T) {
		char[] chs = S.toCharArray();
		char[] cht = T.toCharArray();
		int start = 0;
		int end = 0;
		int minLen = Integer.MAX_VALUE;
		String minStr = "";
		boolean full = false;
		Map<Character, Integer> eleMap = new HashMap<Character, Integer>();
		Map<Character, Integer> tmpMap = new HashMap<Character, Integer>();
		Set<Character> rest = new HashSet<Character>();
		for (char c : cht) {
			if (!eleMap.containsKey(c)) {
				eleMap.put(c, 1);
			} else {
				eleMap.put(c, eleMap.get(c) + 1);
			}
			tmpMap.put(c, 0);
			rest.add(c);
		}
		while (end < S.length()) {
			if (full) {
				if (end - start - 1 < minLen) {
					minStr = S.substring(start, end);
					minLen = minStr.length();
				}
			}
			char curr = chs[end];
			if (!tmpMap.containsKey(curr)) {
				end++;
				continue;
			}
			if (start == 0 && !eleMap.containsKey(chs[0])) {
				start = end;
			}
			tmpMap.put(curr, tmpMap.get(curr) + 1);
			if (full == false) {
				if (eleMap.get(curr) <= tmpMap.get(curr)) {
					rest.remove(curr);
				}

				full = rest.isEmpty();
			}
			if (full) {
				while (start < end) {
					if (end - start - 1 < minLen) {
						minStr = S.substring(start, end + 1);
						minLen = minStr.length();
					}
					char ch_start = chs[start];
					if (!eleMap.containsKey(ch_start)) {
						start++;
						continue;
					}
					// check whether to remove ch_start
					if (eleMap.get(ch_start) <= tmpMap.get(ch_start) - 1) {
						start++;
						tmpMap.put(ch_start, tmpMap.get(ch_start) - 1);
					} else {
						break;
					}
				}
			}
			end++;
		}
		if (full) {
			if (end - start - 1 < minLen) {
				minStr = S.substring(start, end);
				minLen = minStr.length();
			}
		}
		return minStr;
	}

//	private boolean check(Map<Character, Integer> eleMap,
//			Map<Character, Integer> tmpMap, char[] cht) {
//		for (char c : cht) {
//			if (tmpMap.get(c) < eleMap.get(c)) {
//				return false;
//			}
//		}
//		return true;
//	}
}
