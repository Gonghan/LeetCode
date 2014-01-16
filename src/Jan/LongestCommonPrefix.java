package Jan;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            prefix=getPrefix(prefix,strs[i]);
        }
        return prefix;
    }
    
    private String getPrefix(String prefix,String current){
        String result="";
        for(int i=0;i<prefix.length();i++){
            if(i<current.length() && prefix.charAt(i)==current.charAt(i)){
                result+=prefix.charAt(i);
            }else{
                break;
            }
        }
        return result;
    }
}
