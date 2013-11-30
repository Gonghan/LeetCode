package Nov;

public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalRectangleSolution s = new MaximalRectangleSolution();
		char[][] matrix = { {'1'} };
		System.out.println(s.maximalRectangle(matrix));
		
	}

}

class MaximalRectangleSolution {
	public int maximalRectangle(char[][] matrix) {
		// create a new matrix to represent the following
		// 0 1 1 1 0
		// =>
		// 0 3 2 1 0
		// for one element, the number of 1s counting from it(from left to
		// right)
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int height = matrix.length;
		int width = matrix[0].length;
		int[][] numOf1s = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (matrix[i][j] == '0') {
					numOf1s[i][j] = 0;
				}
				if (matrix[i][j] == '1') {
					if (j >= 1 && matrix[i][j - 1] == '1') {
						numOf1s[i][j] = numOf1s[i][j - 1] - 1;
					} else {
						int k = j;
						int counter = 0;
						while (k < width && matrix[i][k] == '1' ) {
							counter++;
							k++;
						}
						numOf1s[i][j] = counter;
					}
				}
			}
		}
		int maxArea = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// start point: i,j
				if(numOf1s[i][j]==0){
					continue;
				}
				int minWidth=numOf1s[i][j];
				for(int k=i;k<height;k++){
					minWidth=Math.min(minWidth, numOf1s[k][j]);
					maxArea=Math.max(minWidth*(k-i+1),maxArea);
				}
			}
		}
		return maxArea;

	}
}