package Jan;

/*
 * Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII {

	public static void main(String args[]) {
		NQueensII n = new NQueensII();
		int result = n.totalNQueens(5);
		System.out.println(result);
	}

	private int result;

	public int totalNQueens(int n) {
		this.result = 0;
		if (n == 0) {
			return 0;
		}
		int[] array = new int[n];
		nQueens(n, 0, array);
		return result;
	}

	// n:N-queens
	// i:the current line
	// array: the completed lines,
	private void nQueens(int n, int i, int[] array) {
		if (i == n) {
			this.result++;
		}
		for (int j = 0; j < n; j++) {
			// check if [i][j] is valid
			// check shu
			boolean valid = true;
			for (int tmp = 0; tmp < i; tmp++) {
				if (array[tmp] == j) {
					valid = false;
					break;
				}
			}
			if (valid == false) {
				continue;
			}
			// check xie
			for (int tmp = 0; tmp < i; tmp++) {
				int value = array[tmp];
				if (i - tmp == j - value || i - tmp == value - j) {
					valid = false;
					break;
				}
			}
			if (valid == false) {
				continue;
			}
			int[] newArray = new int[n];
			for (int tmp = 0; tmp < array.length; tmp++) {
				newArray[tmp] = array[tmp];
			}
			newArray[i] = j;
			nQueens(n, i + 1, newArray);
		}
	}
}
