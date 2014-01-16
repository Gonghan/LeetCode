package Jan;

import java.util.ArrayList;

public class generateParenthese {

	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result=new ArrayList<String>();
        generate("",n,result);
        
        return result;
    }
    
    private void generate(String current,int n, ArrayList<String> result){
        //check nums of ( and )
        int num1=numOfChar(current,'(');
        int num2=numOfChar(current,')');
        if(num2>num1 || num1>n){
            return;
        }
        if(current.length()==2*n){
            result.add(current);
            return;
        }
        generate(current+"(",n,result);
        generate(current+")",n,result);
    }
    
    private int numOfChar(String s,char ch){
        int num=0;
        for(char i:s.toCharArray()){
            if(ch==i){
                num++;
            }
        }
        return num;
    }
}
