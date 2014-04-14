package February;

import java.util.Arrays;

public class WillcardMatching {

//	private boolean dp[][];
	public boolean isMatch(String s, String p) {
		boolean result = false;
		p = removeStars(p);
//		dp=new boolean[s.length()+1][p.length()+1];
		// 3 types:
		// 1. b
		// 2. ?
		// 3. *=>0,1,1+
		result = isMatch(s.toCharArray(), p.toCharArray());

		return result;
	}

	private boolean isMatch(char[] s, char[] p) {
		if (s.length == 0) {
			if (p == null || p.length == 0) {
				return true;
			}
			if (p[0] == '*') {
				return isMatch(s, getFrom2nd(p));
			}
			return false;
		}
		if(p.length==1 && p[0]=='*'){
			return true;
		}
		if (p == null || p.length == 0) {
			return false;
		}
		if (s[0] == p[0] || p[0] == '?') {
			return isMatch(getFrom2nd(s), getFrom2nd(p));
		}
		if (p[0] == '*') {
			// *=0,1,1+
			return isMatch(s, getFrom2nd(p))
					|| isMatch(getFrom2nd(s), getFrom2nd(p))
					|| isMatch(getFrom2nd(s), p);
		}

		return false;
	}

	private char[] getFrom2nd(char[] s) {
		return Arrays.copyOfRange(s, 1, s.length);
	}

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
