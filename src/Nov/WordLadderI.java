package Nov;

import java.util.ArrayList;
import java.util.HashSet;

public class WordLadderI {

	public static void main(String[] args) {
		WordLadderISolution s = new WordLadderISolution();
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		int distance = s.ladderLength("hit", "cog", dict);

		System.out.println(distance);

	}

}

class WordLadderISolution {
	private int SHORTEST_DISTANCE;

	public int ladderLength(String start, String end, HashSet<String> dict) {
		SHORTEST_DISTANCE = Integer.MAX_VALUE;
		ArrayList<String> list = new ArrayList<String>();
		list.add(start);
		findLadders(start, end, list, dict);
		return SHORTEST_DISTANCE;
	}

	private void findLadders(String start, String end, ArrayList<String> path,
			HashSet<String> dict) {
		if (path.size() >= SHORTEST_DISTANCE) {
			return;
		}
		if (difference(end, start) == 1) {
			SHORTEST_DISTANCE = path.size() + 1;
		}
		ArrayList<String> similiar = this.getSimiliarWords(start, dict);
		for (String s : similiar) {
			if (path.contains(s) == false) {
				path.add(s);
				findLadders(s, end, path, dict);
				path.remove(s);
			}
		}

	}

	private int difference(String a, String b) {
		int length = a.length();
		int counter = 0;
		for (int i = 0; i < length; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				counter++;
			}
		}
		return counter;
	}

	// find all words in dict, which the difference is 1
	private ArrayList<String> getSimiliarWords(String str, HashSet<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		for (String s : dict) {
			if (difference(s, str) == 1) {
				result.add(s);
			}
		}
		return result;
	}
}