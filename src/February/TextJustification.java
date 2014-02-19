package February;

import java.util.ArrayList;

public class TextJustification {

	public static void main(String args[]) {
		TextJustification t = new TextJustification();
		String[] words = { "This", "is", "an", "example", "of", "text",
				"justification." };
		int L = 16;
		System.out.println(t.fullJustify(words, L));
	}

	
	ArrayList<String> lastlist;
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String>result=new ArrayList<>();
		ArrayList<String>tmplist=new ArrayList<>();
		int tmpsum=0;
		for(int i=0;i<words.length;i++){
			String word=words[i];
			int len=word.length();
			if(tmpsum+len<L){
				tmpsum+=len+1;
				tmplist.add(word);
				continue;
			}
			if(tmpsum+len==L){
				tmpsum+=len;
				tmplist.add(word);
//				result.add(get(tmplist,L));
			}else{
				i--;
			}
			
			result.add(get(tmplist,L));
			tmplist.clear();
			tmpsum=0;
		}
		if(!tmplist.isEmpty()){
			result.add(get(tmplist,L));
		}
		
		
		if (!lastlist.isEmpty()) {
			result.remove(result.size() - 1);
			String tmpresult = lastlist.get(0);
			for (int i = 1; i < lastlist.size(); i++) {
				tmpresult += " " + lastlist.get(i);
			}
			tmpresult += getBlanks(L - tmpresult.length());
			result.add(tmpresult);
		}
		return result;
	}
	
	private String get(ArrayList<String>list,int L){
		lastlist=list;
		int size=list.size();
		if(size==1){
			return list.get(0)+getBlanks(L-list.get(0).length());
		}
		int sum=0;
		for(String s:list){
			sum+=s.length();
		}
		int remain=L-sum;
		int span=remain/(size-1);
		String tmp="";
		for(int i=0;i<size-1;i++){
			String blanks=getBlanks(span);
			if(i<remain-span*(size-1)){
				blanks+=" ";
			}
			tmp+=list.get(i)+blanks;
		}
		tmp+=list.get(size-1);
		return tmp;
	}

	private String getBlanks(int num) {
		String result = "";
		for (int i = 0; i < num; i++) {
			result += " ";
		}
		return result;
	}
}
