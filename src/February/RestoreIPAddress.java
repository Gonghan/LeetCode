package February;

import java.util.ArrayList;

/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddress {

	public static void main(String args[]) {
		System.out.println(new RestoreIPAddress()
				.restoreIpAddresses("0279245587303"));
	}

	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> result = new ArrayList<String>();
		process(result, "", 4, s);
		return result;
	}

	private void process(ArrayList<String> result, String path, int left,
			String s) {
		if (left <= 0) {
			if (s.isEmpty()) {
				result.add(path);
			}
			return;
		}
		if (s.isEmpty()) {
			return;
		}
		if (left == 1) {
			if (s.length() > 4 || !isValid(s)) {
				return;
			}
			int tmp = Integer.parseInt(s);
			process(result, path + tmp, 0, "");
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (i >= s.length()) {
				continue;
			}
			String tmp = s.substring(0, i + 1);
			if (!isValid(tmp)) {
				continue;
			}
			int tmpv = Integer.parseInt(tmp);
			process(result, path + tmpv + ".", left - 1,
					s.substring(i + 1, s.length()));
		}
	}

	private boolean isValid(String s) {
		if (s.length() == 1) {
			return true;
		}
		if (s.charAt(0) == '0') {
			return false;
		}
		int tmp = Integer.parseInt(s);
		if (tmp >= 256) {
			return false;
		}
		return true;
	}
}
