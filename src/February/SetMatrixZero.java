package February;

/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.

 Follow up:
 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?
 */
public class SetMatrixZero {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null
				|| matrix[0].length == 0) {
			return;
		}
		int width = matrix[0].length;
		int height = matrix.length;
		int[] shu = new int[width];// 1=set to 0; 0=do nothing
		int[] heng = new int[height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (matrix[i][j] == 0) {
					heng[i] = 1;
					shu[j] = 1;
				}
			}
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (heng[i] == 1 || shu[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
