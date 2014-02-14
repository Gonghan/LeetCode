package February;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.

 click to show spoilers.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.
 */

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x == 0) {
			return true;
		}
		int max = Integer.MAX_VALUE;
		int p = x;
		int r = 0;
		while (x > 0) {
			if ((max - x % 10) / 10 <= r) {
				return false;
			}
			r = 10 * r + x % 10;
			x = x / 10;
		}
		if (r == p) {
			return true;
		}
		return false;
	}
}
