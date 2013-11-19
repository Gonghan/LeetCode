package Nov;

import java.util.ArrayList;
import java.util.HashSet;

public class WordLadder {
	
	public static void main(String args[]){
		WordLadderSolution solution=new WordLadderSolution();
		HashSet<String> dict=new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		
		ArrayList<ArrayList<String>> result=solution.findLadders("hot", "dog", dict);
		System.out.println(result);
	}
	
}

class WordLadderSolution {
	private int SHORTEST_DISTANCE=Integer.MAX_VALUE;
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        //Start time: 23:46, 2013/11/18
        
        ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
        
        if(start==null || end== null){
            //should throw exception
            return null;
        }
        if(start.isEmpty() || end.isEmpty()){
            //should throw exception
            return null;
        }
        if(start.length()!=end.length()){
            //should throw exception
            return null;
        }
        ArrayList<String> path= new ArrayList<String>();
        path.add(start);
        findLadders(start,end,path,dict,result);
        for(ArrayList<String> tmp:result){
            if(tmp.size()!=SHORTEST_DISTANCE){
                result.remove(tmp);
            }
        }
        return result;
    }
    
    //find all one difference from start
    //check if it is end
    public void findLadders(String start,String end, ArrayList<String> path,HashSet<String> dict,ArrayList<ArrayList<String>> result){
        if(difference(end,start)==1){
        	path.add(end);
            if(path.size()<SHORTEST_DISTANCE){
                SHORTEST_DISTANCE=path.size();
            }
            if(path.size()==SHORTEST_DISTANCE){
                result.add(path);    
            }
            return;
        }
        if(path.size()>=SHORTEST_DISTANCE){
            return;
        }
        for(String str:dict){
            if(path.contains(str)){
                continue;
            }
            if(difference(str,start)==1){
                ArrayList<String>newpath=new ArrayList<String>();
                for(String s:path){
                    newpath.add(s);
                }
                newpath.add(str);
                findLadders(str,end,newpath,dict,result);
            }
        }
        
    }
    
    //find the difference between a and b
    //For example, difference of abc and adc is 2
    // difference of abc and cab is 3
    private int difference(String a,String b){
        int length=a.length();
        int counter=0;
        for(int i=0;i<length;i++){
            if(a.charAt(i)!=b.charAt(i)){
                counter++;
            }
        }
        return counter;
    }
}