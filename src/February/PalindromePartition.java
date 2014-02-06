package February;

import java.util.ArrayList;
import java.util.HashMap;

public class PalindromePartition {

	public static void main(String args[]) {
		PalindromePartition p = new PalindromePartition();
		System.out.println(p.partition("ABBACC"));
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		if (s == null || s.length() == 0) {
			return new ArrayList<ArrayList<String>>();
		}
		ArrayList<ArrayList<String>> empty = new ArrayList<ArrayList<String>>();
		empty.add(new ArrayList<String>());
		HashMap<Integer, ArrayList<ArrayList<String>>> cache = new HashMap<Integer, ArrayList<ArrayList<String>>>();
		cache.put(-1, empty);
		process(s, cache, 0);
		return cache.get(s.length() - 1);
	}

	private void process(String s,
			HashMap<Integer, ArrayList<ArrayList<String>>> cache, int index) {
		if (index >= s.length()) {
			return;
		}
		if (index == -1) {
			ArrayList<String> sublist = new ArrayList<String>();
			ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
			String first = s.substring(0, 1);
			sublist.add(first);
			list.add(sublist);
			cache.put(0, list);
			process(s, cache, index + 1);
			return;
		}
		
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		for (int i = index; i >= 0; i--) {
			// split s into [0,i],[i,index]
			String second = s.substring(i, index + 1);
			if (isPalindrome(second)) {
				// cache.get(i-1)=> each node add second
				ArrayList<ArrayList<String>> tmplist = cache.get(i - 1);
				for (ArrayList<String> subtmplist : tmplist) {
					ArrayList<String> newsubtmplist = (ArrayList<String>) subtmplist
							.clone();
					newsubtmplist.add(second);
					list.add(newsubtmplist);

				}
			}
		}
		cache.put(index, list);
		process(s, cache, index + 1);
	}

	private boolean isPalindrome(String s) {
		if (s.isEmpty()) {
			return false;
		}
		if (s.length() == 1) {
			return true;
		}
		boolean result = true;
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] != chs[chs.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}
}
