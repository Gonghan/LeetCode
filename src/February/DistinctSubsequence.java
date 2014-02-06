package February;

public class DistinctSubsequence {

	public static void main(String args[]) {
		DistinctSubsequence d = new DistinctSubsequence();
		System.out.println(d.numDistinct("ABCACAC", "AC"));
	}

	public int numDistinct(String S, String T) {
		int lens = S.length();
		int lent = T.length();
		if (S.isEmpty() || T.isEmpty()) {
			return 0;
		}
		int dp[][] = new int[lent][lens];

		char[] chs = S.toCharArray();
		char[] cht = T.toCharArray();

		for (int i = 0; i < lent; i++) {
			for (int j = i; j < lens; j++) {
				char t = cht[i];
				char s = chs[j];
				if (t != s) {
					dp[i][j] = get(dp, i, j - 1);
				} else {
					if (i == 0) {
						dp[i][j] = get(dp, i, j - 1) + 1;
					} else {
						dp[i][j] = get(dp, i - 1, j-1) + get(dp, i, j - 1);
					}
				}
			}
		}
		return dp[lent - 1][lens - 1];
	}

	private int get(int dp[][], int i, int j) {
		if (j < 0) {
			return 0;
		}
		return dp[i][j];
	}
}
