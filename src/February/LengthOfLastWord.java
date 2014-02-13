package February;

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		String[] strs = s.split(" ");
		if (strs.length == 0) {
			return 0;
		}
		String last = strs[strs.length - 1];
		if (last.isEmpty()) {
			return 0;
		}
		return last.length();
	}
}
