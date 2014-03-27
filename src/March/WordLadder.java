package March;

import java.util.*;

public class WordLadder {

	public static void main(String args[]) {
		HashSet<String> dict = new HashSet<>();
		String start = "red";
		String end = "tax";
		String[] strs = { "ted", "tex", "red", "tax", "tad", "den", "rex",
				"pee" };
		dict.addAll(Arrays.asList(strs));
		System.out.println(new WordLadder().findLadders(start, end, dict));
	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (start.isEmpty()) {
			return result;
		}
		// start='a', end='c', result=[a,c]
		if (start.length() == 1) {
			ArrayList<String> tmp = new ArrayList<>();
			tmp.add(start);
			tmp.add(end);
			result.add(tmp);
			return result;
		}
		// bfs
		// use arraylist<string> to show the path
		Queue<ArrayList<String>> queue = new LinkedList<ArrayList<String>>();
		ArrayList<String> first = new ArrayList<>();
		first.add(start);
		queue.offer(first);
		int depth = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			ArrayList<String> list = queue.poll();
			if (list.size() > depth) {
				continue;
			}
			String curr = list.get(list.size() - 1);
			if (curr.equals(end)) {
				result.add(list);
				depth = list.size();
				continue;
			}
			ArrayList<String> nextStrs = getNext(dict, curr, end,list);
			for (String s : nextStrs) {
				ArrayList<String> tmplist = (ArrayList<String>) list.clone();
				tmplist.add(s);
				queue.offer(tmplist);
			}
		}
		return result;
	}

	private ArrayList<String> getNext(Set<String> dict, String curr,
			String end,ArrayList<String>list) {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < curr.length(); i++) {
			StringBuffer sb = new StringBuffer(curr);
			for (char c = 'a'; c <= 'z'; c++) {
				sb.setCharAt(i, c);
				String tmp = sb.toString();
				if (!curr.equals(tmp)&& dict.contains(tmp) && !list.contains(tmp)) {
					result.add(tmp);
				} else if (tmp.equals(end)) {
					result.add(tmp);
				}
			}
		}
		return result;
	}
}
