package February;


public class WildcardMatching {

	public static void main(String args[]) {
		WildcardMatching w = new WildcardMatching();
		System.out.println(w.isMatch("cabab", "*abe"));
	}

	// dp=0: unset
	// =1: true
	// =2: false
	int dp[][];

	public boolean isMatch(String s, String p) {
		dp = new int[s.length() + 1][p.length() + 1];
		boolean result = false;
		p = removeStars(p);
		// 3 types:
		// 1. b
		// 2. ?
		// 3. *=>0,1,1+
		result = isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
		return result;
	}

	// ps is the current pointer of s
	// pp is the current pointer of p
	private boolean isMatch(char[] s, char[] p, int ps, int pp) {
		// int ps = s.length;
		// int pp = p.length;
		if (dp[ps][pp] == 1) {
			return true;
		}
		if (dp[ps][pp] == 2) {
			return false;
		}

		if (s.length - ps == 0) {
			if (p == null || p.length - pp == 0) {
				dp[ps][pp] = 1;
				return true;
			}
			if (p[0 + pp] == '*') {
				boolean result = isMatch(s, p, ps, pp + 1);
				dp[ps][pp] = get(result);
				return result;
			}
			dp[ps][pp] = 2;
			return false;
		}
		if (p == null || p.length - pp == 0) {
			dp[ps][pp] = 2;
			return false;
		}
		if (s[ps] == p[pp] || p[pp] == '?') {
			boolean result = isMatch(s, p, ps + 1, pp + 1);
			dp[ps][pp] = get(result);
			return result;
		}
		if (p[pp] == '*') {
			// *=0,1,1+
			boolean result = isMatch(s, p, ps, pp + 1)
					|| isMatch(s, p, ps + 1, pp + 1)
					|| isMatch(s, p, ps + 1, pp);
			dp[ps][pp] = get(result);
			return result;
		}

		dp[ps][pp] = 2;
		return false;
	}

	private int get(boolean b) {
		if (b) {
			return 1;
		}
		return 2;
	}
//
//	private char[] getFrom2nd(char[] s) {
//		return Arrays.copyOfRange(s, 1, s.length);
//	}

	private String removeStars(String s) {
		StringBuffer sb = new StringBuffer(s);
		for (int i = 1; i < sb.length(); i++) {
			if (sb.charAt(i) == '*' && sb.charAt(i - 1) == '*') {
				sb.deleteCharAt(i);
				i--;
			}
		}
		return sb.toString();
	}
}
