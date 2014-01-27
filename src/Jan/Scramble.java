package Jan;

import java.util.Arrays;

public class Scramble {

	public static void main(String args[]) {
		Scramble s = new Scramble();
		boolean result=s.isScramble("hobobyrqd", "hbyorqdbo");
		System.out.println(result);
	}

	public boolean isScramble(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if (s1.equals(s2)) {
			return true;
		}
		if (checkStrings(s1, s2) == false) {
			return false;
		}
		String tmp1 = "";
		String tmp2 = "";
		String tmp3 = "";
		boolean result=false;
		for (int i = 0; i < s1.length()-1; i++) {
			tmp1 += s1.charAt(i);
			tmp2 += s2.charAt(i);
			tmp3 += s2.charAt(s1.length() - i - 1);
			if (checkStrings(tmp1, tmp2)) {
				boolean left = isScramble(tmp1, tmp2);
				boolean right = isScramble(s1.substring(i + 1, s1.length()),
						s2.substring(i + 1, s2.length()));
				result= left && right;
			}
			if(result){
				return true;
			}
			if (checkStrings(tmp1, tmp3)) {
				boolean left = isScramble(tmp1, tmp3);
				boolean right = isScramble(s1.substring(i + 1, s1.length()),
						s2.substring(0, s1.length()-i-1));
				result= left && right;
			}
			if(result){
				return true;
			}
		}
		return false;
	}

	// check two strings have the same chars
	public boolean checkStrings(String s1, String s2) {
		char chs1[] = s1.toCharArray();
		char chs2[] = s2.toCharArray();
		Arrays.sort(chs1);
		Arrays.sort(chs2);
		return Arrays.equals(chs1, chs2);
	}
}
