package February;

/*
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
	
	public static void main(String args[]){
		LongestPalindromicSubstring s=new LongestPalindromicSubstring();
		System.out.println(s.longestPalindrome("bananas"));
	}

	// M[i][j]=true(i>=j), so s.substring(i,j+1) is palindromic
	// M[i][i]=true,
	private boolean M[][] = new boolean[1001][1001];

	public String longestPalindrome(String s) {
		char[] chs = s.toCharArray();
		int len = chs.length;
		String str = "";
		int maxLen = 0;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; i + j-1 < len; j++) {
				if (chs[j] == chs[j + i-1]) {
					M[j][i + j-1] = get(j + 1, i + j - 2);
					if (M[j][i + j-1] == true && maxLen < i+1) {
						str = s.substring(j, j + i);
						maxLen=i+1;
					}
				} else {
					M[j][i+j-1] = false;
				}
			}
		}
		return str;
	}

	private boolean get(int i, int j) {
		if (i >= j) {
			return true;
		}
		return M[i][j];
	}
}
