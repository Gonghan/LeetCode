package Jan;

import java.util.ArrayList;

public class NQueens {

	public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]>result=new ArrayList<String[]>();
        solve(result,new String[n],0,n);
        return result;
    }
    
    private void solve(ArrayList<String[]>result,String []strs,int now,int n){
        int total=strs.length;
        if(now==n){
            result.add(strs);
            return;
        }
        
        for(int i=0;i<total;i++){
            
            boolean toContinue=false;
            for(int j=0;j<now;j++){
                //check vertical line
                char ch=strs[j].charAt(i);
                if(ch=='Q'){
                    toContinue=true;
                    break;
                }
                //check diagonal
                int diff=now-j;
                int newPosLeft=i-diff;
                int newPosRight=i+diff;
                if(newPosLeft>=0 && strs[j].charAt(newPosLeft)=='Q'){
                    toContinue=true;
                    break;
                }
                if(newPosRight<total && strs[j].charAt(newPosRight)=='Q'){
                    toContinue=true;
                    break;
                }
            }
            if(toContinue==true){
                continue;
            }
            if(toContinue==false){
                //create new string and new string[]
                String newString="";
                for(int j=0;j<total;j++){
                    if(j==i){
                        newString+="Q";
                    }else{
                        newString+=".";
                    }
                }
                String[] newStrs=new String[total];
                for(int j=0;j<total;j++){
                    newStrs[j]=strs[j];
                }
                newStrs[now]=newString;
                solve(result,newStrs,now+1,n);
            }
        }
    }
}
