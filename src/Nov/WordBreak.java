package Nov;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

	public static void main(String args[]) {
		WordBreakSolution s = new WordBreakSolution();
		Set<String> dict = new HashSet<String>();
		dict.add("apple");
		dict.add("orange");
		System.out.println(s.wordBreak("applepie", dict));
	}

}

class WordBreakSolution {
	private Set<String> wrongWords;

	public boolean wordBreak(String s, Set<String> dict) {
		wrongWords = new HashSet<String>();
		if (s == null || s.isEmpty() || dict == null || dict.isEmpty()) {
			return false;
		}
		// split and recurse
		return breakSubString(s, dict);
	}

	private boolean breakSubString(String s, Set<String> dict) {
		if (s.length() == 0) {
			return true;
		}
		if (dict.contains(s)) {
			return true;
		}
		if (s.length() == 1) {
			return false;
		}
		if (wrongWords.contains(s)) {
			return false;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			String first = s.substring(0, i + 1);
			String second = s.substring(i + 1, s.length());
			if (breakSubString(first, dict) && breakSubString(second, dict)) {
				return true;
			}
		}
		wrongWords.add(s);
		return false;
	}
}