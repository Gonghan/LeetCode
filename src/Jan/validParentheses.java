package Jan;

public class validParentheses {

	public boolean isValid(String s) {
		char[] array = s.toCharArray();
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
		for (int i = 0; i < array.length; i++) {
			if (counter1 < 0 || counter2 < 0 || counter3 < 0) {
				return false;
			}
			char current = array[i];
			switch (current) {
			case '(':
				counter1++;
				break;
			case ')':
				counter1--;
				break;
			case '[':
				counter2++;
				break;
			case ']':
				counter2--;
				break;
			case '{':
				counter3++;
				break;
			case '}':
				counter3--;
				break;

			}
		}

		return true;
	}
}
