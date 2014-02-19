package February;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
	
	public static void main(String args[]){
		WordLadder w=new WordLadder();
		HashSet<String> dict=new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(w.ladderLength("hit", "cog",dict));
	}

	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (start.isEmpty() || dict.isEmpty()) {
			return 0;
		}
		return search(start, end, dict);
	}

	private int search(String start, String end, HashSet<String> dict) {
		int len = end.length();
		Queue<Snode> queue = new LinkedList<>();
		queue.offer(new Snode(1, start));
		while (!queue.isEmpty()) {
			Snode tmp = queue.poll();
			if (tmp.str.equals(end)) {
				return tmp.depth;
			}
			for (int i = 0; i < len; i++) {

				char[] chs = tmp.str.toCharArray();
				char old = chs[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (old == c) {
						continue;
					}
					chs[i] = c;
					String newstr = String.copyValueOf(chs);
					if(newstr.equals(end)){
						return tmp.depth+1;
					}
					if (dict.contains(newstr)) {
						dict.remove(newstr);
						queue.offer(new Snode(tmp.depth + 1, newstr));
					}
					chs[i] = old;
				}
			}
		}
		return 0;
	}
}

class Snode {
	public int depth;
	public String str;

	public Snode(int d, String str) {
		this.depth = d;
		this.str = str;
	}
}