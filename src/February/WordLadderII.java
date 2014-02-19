package February;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class WordLadderII {
	
	public static void main(String args[]){
		WordLadderII w=new WordLadderII();
		HashSet<String> dict=new HashSet<String>();
		String array[]={"ted","tex","red","tax","tad","den","rex","pee"};
		for(String s:array){
			dict.add(s);
		}
		System.out.println(w.findLadders("red", "tax",dict));
	}
	
	ArrayList<ArrayList<String>> result;

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		result = new ArrayList<ArrayList<String>>();		
		search(start, end, dict);
		return result;
	}

	private void search(String start, String end, HashSet<String> dict) {
		int minDepth=Integer.MAX_VALUE;
		int len = end.length();
		Queue<ArrayList<String>> queue = new LinkedList<>();
		ArrayList<String> firstlist = new ArrayList<>();
		firstlist.add(start);
		if(start.length()==1 && dict.contains(end)){
			firstlist.add(end);
			result.add(firstlist);
			return;
		}
		queue.offer(firstlist);
		while (!queue.isEmpty()) {
			ArrayList<String> tmplist = queue.poll();
			if(tmplist.size()>minDepth){
				continue;
			}
			String tmpstr = tmplist.get(tmplist.size() - 1);
			if (tmpstr.equals(end)) {
				result.add(tmplist);
				minDepth=Math.min(tmplist.size(),minDepth);
				break;
			}
			for (int i = 0; i < len; i++) {

				char[] chs = tmpstr.toCharArray();
				char old = chs[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (old == c) {
						continue;
					}
					chs[i] = c;
					String newstr = String.copyValueOf(chs);
					ArrayList<String> newtmplist = (ArrayList<String>) tmplist
							.clone();
					if (newstr.equals(end)) {

						newtmplist.add(newstr);
						if(newtmplist.size()<=minDepth){
							result.add(newtmplist);
							minDepth=Math.min(newtmplist.size(),minDepth);
						}
						break;
					}
					if (dict.contains(newstr) && !tmplist.contains(newstr)) {
						dict.remove(newstr);
						newtmplist.add(newstr);
						queue.offer(newtmplist);
					}
					chs[i] = old;
				}
			}
		}
	}
}
