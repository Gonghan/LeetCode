package Jan;

public class ValidPalindrome {
	/*
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 */
	
	public boolean isPalindrome(String s) {
        StringBuffer sb=new StringBuffer();
        for(char c:s.toCharArray()){
            if(Character.isLetter(c) || Character.isDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        for(int i=0;i<sb.length();i++){
            int endIndex=sb.length()-1-i;
            if(endIndex<=i){
                return true;
            }
            char front=sb.charAt(i);
            char end=sb.charAt(endIndex);
            if(front!=end){
                return false;
            }
        }
        return true;
    }
}
