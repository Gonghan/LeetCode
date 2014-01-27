package Jan;

/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class SpiralMatrixII {

	public static void main(String args[]) {
		int[][] matrix = new SpiralMatrixII().generateMatrix(3);
		System.out.println(matrix);
	}

	private int current;

	public int[][] generateMatrix(int n) {
		this.current = 1;
		int[][] matrix = new int[n][n];
		int maxLevel = (n + 1) / 2;
		for (int i = 0; i < maxLevel; i++) {
			generate(matrix, i, n);
		}
		return matrix;
	}

	private void generate(int[][] matrix, int level, int n) {
		int width = n;
		int height = n;
		for (int i = level; i < width - level; i++) {
			matrix[level][i] = current;
			current++;
		}
		// right
		for (int i = level + 1; i < height - level; i++) {
			matrix[i][width - level - 1] = current;
			current++;
		}
		// down
		for (int i = width - level - 2; i >= level; i--) {
			if (height - level - 1 > level) {
				matrix[height - level - 1][i] = current;
				current++;
			}
		}
		// left
		for (int i = height - level - 2; i > level; i--) {
			if (level < width - level - 1) {
				matrix[i][level] = current;
				current++;
			}
		}
	}
}
