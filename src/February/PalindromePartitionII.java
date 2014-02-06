package February;

public class PalindromePartitionII {

	public static void main(String args[]) {
		PalindromePartitionII p = new PalindromePartitionII();
		System.out.println(p.minCut("cddcvcw"));
	}

	public int minCut(String s) {
		if (s.isEmpty()) {
			return 0;
		}
		int len = s.length();
		int[] cache = new int[len];
		boolean dp[][] = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j + i <= len; j++) {
				// s[j->j+i]
				// i=len of str
				if (s.charAt(j) != s.charAt(j + i - 1)) {
					dp[j][j + i - 1] = false;
					continue;
				}
				if (i == 1 || i == 2) {
					dp[j][j + i - 1] = true;
				} else {
					dp[j][j + i - 1] = dp[j + 1][j + i - 2];
				}
				
			}
		}
		cache[0] = 0;
		for (int i = 1; i < len; i++) {
			int tmpMin = Integer.MAX_VALUE;
			if (dp[0][i] == true) {
				cache[i] = 0;
				continue;
			}
			for (int j = i; j > 0; j--) {
				if (dp[j][i]) {
					tmpMin = Math.min(tmpMin, cache[j - 1]+1);
				}
			}
			cache[i] = tmpMin;
		}
		return cache[s.length() - 1];
	}
}
