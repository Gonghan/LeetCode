package Nov;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

}
class ValidParenthesesSolution {
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return false;
        }
        Stack<Character> stack=new Stack<Character>();
        char []charArray=s.toCharArray();
        for(int i=0;i<charArray.length;i++){
            char currentChar=charArray[i];
            if(currentChar=='(' || currentChar=='[' || currentChar=='{' ){
                stack.push(currentChar);
            }else{
                if(stack.empty()){
                    return false;
                }
                char previousChar=stack.peek();
                if( arePair(previousChar,currentChar)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
    private boolean arePair(char previous, char current){
        if(previous=='(' && current==')'){
            return true;
        }
        if(previous=='[' && current==']'){
            return true;
        }
        if(previous=='{' && current=='}'){
            return true;
        }
        return false;
    }
}