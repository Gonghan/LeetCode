package Nov;

public class LongestPrefix {
	public static void main(String args[]){
		String[] strs={"ABC","ABD","AB","ABCHJHUU"};
		LongestPrefixSolution s=new LongestPrefixSolution();
		String result=s.longestCommonPrefix(strs);
		System.out.println(result);
	}

}
class LongestPrefixSolution {
    public String longestCommonPrefix(String[] strs) {
        assert(strs!=null);
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            prefix=commonPrefix(prefix,strs[i]);
        }
        return prefix;
    }
    private String commonPrefix(String s1,String s2){
        String result="";
        char []charArray1=s1.toCharArray();
        char []charArray2=s2.toCharArray();
        for(int i=0;i<charArray1.length;i++){
            if(i>=charArray2.length){
                return result;
            }
            if(charArray1[i]==charArray2[i]){
                result+=""+charArray1[i];
            }else{
                return result;
            }
        }
        return result;
    }
}