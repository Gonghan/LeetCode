package February;

public class EditDistance {
	

	public int minDistance(String word1, String word2) {
		int len1=word1.length();
		int len2=word2.length();
		int distance[][]=new int[len2+1][len1+1];
		char[] chs1=word1.toCharArray();
		char[] chs2=word2.toCharArray();
		for(int i=0;i<=len1;i++){
			distance[0][i]=i;
		}
		for(int i=0;i<=len2;i++){
			distance[i][0]=i;
		}
		
		for(int i=1;i<=len1;i++){
			for(int j=1;j<=len2;j++){
				if(chs1[i-1]==chs2[j-1]){
					distance[j][i]=distance[j-1][i-1];
				}else{
					distance[j][i]=1+Math.min(distance[j-1][i-1], Math.min(distance[j][i-1],distance[j-1][i]));
				}
			}
		}
		
		return distance[len2][len1];
	}
}
