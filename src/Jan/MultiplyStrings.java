package Jan;

public class MultiplyStrings {

	public static void main(String args[]) {
		MultiplyStrings ms = new MultiplyStrings();
		String result = ms.multiply("123", "456");
		System.out.println(result);
	}

	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		// First, convert the string into int array in reversed order
		// "321"=>[1,2,3]
		char[] charArray1 = num1.toCharArray();
		char[] charArray2 = num2.toCharArray();

		int[] intArray1 = new int[charArray1.length];
		int[] intArray2 = new int[charArray2.length];

		for (int i = 0; i < charArray1.length; i++) {
			intArray1[i] = charArray1[charArray1.length - i - 1] - '0';
		}

		for (int i = 0; i < charArray2.length; i++) {
			intArray2[i] = charArray2[charArray2.length - i - 1] - '0';
		}
		int result[] = new int[intArray1.length + intArray2.length];

		// 123*456=>1*456+20*456+300*456
		// 3*456=>2+(1+5)*10+(1+8)*100+1*1000
		int carry[] = new int[intArray1.length + intArray2.length];
		for (int i = 0; i < intArray1.length; i++) {
			int first = intArray1[i];

			for (int j = 0; j < intArray2.length; j++) {
				int current = intArray2[j];
				int newValue = first * current + result[i + j] + carry[i + j];
				carry[i+j]=0;
				carry[i + j + 1] += newValue / 10;
				result[i + j] = newValue % 10;
			}
		}

		result[intArray1.length + intArray2.length - 1] = carry[intArray1.length
				+ intArray2.length - 1];

		StringBuffer sb = new StringBuffer();
		for (int i : result) {
			sb.append(i);
		}
		sb.reverse();
		// remove first zeros
		while (sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
}
