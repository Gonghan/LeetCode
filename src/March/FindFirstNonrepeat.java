package March;

import java.util.HashSet;
import java.util.Set;

public class FindFirstNonrepeat {

	public static void main(String args[]) {
		System.out.println(new FindFirstNonrepeat().findFirstNonR("geeksforgeeks"));
	}

	public char findFirstNonR(String s) {
		Set<Character> set = new HashSet<>();
		Set<Character> repeatedSet = new HashSet<>();
		for (char c : s.toCharArray()) {
			c=Character.toLowerCase(c);
			if (set.contains(c)) {
				repeatedSet.add(c);
			} else {
				set.add(c);
			}
		}
		for (char c : s.toCharArray()) {
			if (!repeatedSet.contains(c)) {
				return c;
			}
		}
		return '0';
	}
}
