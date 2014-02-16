package February;

/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {

	public static void main(String args[]){
		InterleavingString i=new InterleavingString();
		System.out.println(i.isInterleave("a", "b", "a"));
	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.isEmpty()) {
			return s2.equals(s3);
		}
		if (s2.isEmpty()) {
			return s1.equals(s3);
		}
		if(s1.length()+s2.length()!=s3.length()){
			return false;
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();
		// dp[x][y]=true=> x=number of chars taken from s1, first x chars+ first
		// y chars =>first x+y chars from s3
		boolean dp[][] = new boolean[c1.length + 1][c2.length + 1];
		for (int i = 0; i < c1.length + 1; i++) {
			for (int j = 0; j < c2.length + 1; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
					continue;
				}
				boolean match1 = get(i - 1, j, dp)
						&& c1[i - 1] == c3[i + j - 1];
				boolean match2 = get(i, j - 1, dp)
						&& c2[j - 1] == c3[i + j - 1];
				dp[i][j] = match1 || match2;
			}
		}
//		for(boolean []a:dp){
//			for(boolean b:a){
//				if(b){
//					System.out.print("T,");
//				}else{
//					System.out.print("F,");
//				}
//			}
//			System.out.println();
//		}
		return dp[c1.length][c2.length];
	}

	private boolean get(int i, int j, boolean[][] dp) {
		if (i < 0 || j < 0) {
			return false;
		}
		return dp[i][j];
	}
}
