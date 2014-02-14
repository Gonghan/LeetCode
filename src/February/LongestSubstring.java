package February;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public static void main(String args[]) {
		System.out
				.println(new LongestSubstring()
						.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s.isEmpty()) {
			return 0;
		}
		char[] chs = s.toCharArray();
		int len = chs.length;
		int max = 1;
		int low = 0;
		int high = 1;
		Set<Character> set = new HashSet<>();
		set.add(chs[0]);
		while (low <= high && high < len) {
			char curr = chs[high];
			if (!set.contains(curr)) {
				set.add(curr);
			} else {
				while (true) {
					if (low >= high) {

						break;
					}
					if (chs[low] == curr) {
						low++;
						break;
					} else {
						set.remove(chs[low]);
						low++;
					}
				}
			}
			max = Math.max(high - low + 1, max);
			high++;
		}
		return max;
	}
}
