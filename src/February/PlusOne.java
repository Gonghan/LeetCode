package February;

public class PlusOne {

	public static void main(String args[]) {
		int[] A = { 9};
		int[] B = new PlusOne().plusOne(A);
		for (int b : B)
			System.out.println(b);
	}

	public int[] plusOne(int[] digits) {
		if (digits.length == 0) {
			int A[] = { 1 };
			return A;
		}
		int len = digits.length;
		int[] reversed = new int[len + 1];
		for (int i = 0; i < len; i++) {
			reversed[i] = digits[len - i - 1];
		}
		reversed[len] = 0;
		int carry = 0;
		for (int i = 0; i < len; i++) {
			int sum = reversed[i] + carry;
			if (i == 0) {
				sum++;
			}
			carry = sum / 10;
			reversed[i] = sum % 10;
		}
		reversed[len] = carry;
		if (reversed[len] == 1) {
			len = len + 1;
		}
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			result[i] = reversed[len - i - 1];
		}
		return result;
	}
}
