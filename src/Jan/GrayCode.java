package Jan;

import java.util.ArrayList;

public class GrayCode {

	public static void main(String args[]) {
		GrayCode g = new GrayCode();
		System.out.println(g.grayCode(2));
	}

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Integer> intResult = new ArrayList<Integer>();
		if (n == 0) {
			intResult.add(0);
			return intResult;
		}
		String base = "";
		for (int i = 0; i < n; i++) {
			base += "0";
		}
		int i = 0;
		while (true) {
			if (i == 0) {
				result.add(base);
				i++;
				continue;
			}
			boolean findNew = false;
			for (int j = 0; j < n; j++) {
				String newString = newString(result.get(result.size() - 1), n-1-j);
				if (contains(result, newString)) {
					findNew = false;
					continue;
				} else {
					findNew = true;
					result.add(newString);
					break;
				}
			}
			if (findNew == false) {
				break;
			}
			i++;
		}

		for (String s : result) {
			intResult.add(Integer.parseInt(s, 2));
		}
		return intResult;
	}

	// change the ith bit
	private String newString(String s, int i) {
		StringBuffer sb = new StringBuffer(s);
		char a = sb.charAt(i);
		char b = '0';
		if (a == '0') {
			b = '1';
		}
		sb.setCharAt(i, b);
		return sb.toString();
	}

	private boolean contains(ArrayList<String> result, String str) {
		boolean res = false;
		for (String s : result) {
			if (s.equals(str)) {
				return true;
			}
		}
		return res;
	}

	public ArrayList<Integer> grayCode2(int n) {

		ArrayList<Integer> l = new ArrayList<Integer>();

		if (n == 0) {

			l.add(0);

			return l;

		}

		l.add(0);
		l.add(1);

		for (int i = 2; i <= n; i++) {

			for (int j = 0; j < l.size(); j++) {

				l.set(j, l.get(j) << 1);

				l.add(l.get(j) + 1);

			}

		}

		return l;

	}
}
