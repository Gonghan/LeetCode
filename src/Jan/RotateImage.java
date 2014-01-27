package Jan;

/*
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 */
public class RotateImage {

	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null
				|| matrix[0].length == 0) {
			return;
		}
		int n = matrix.length;
		// M[x][y]=>M[y][n-1-x]
		// M[y][n-1-x]=>M[n-1-x,n-1-y]
		// M[n-1-x,n-1-y]=>M[n-1-y][x]
		boolean[][] visited = new boolean[n][n];
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (visited[x][y]) {
					continue;
				}
				int v1 = matrix[x][y];
				int v2 = matrix[y][n - 1 - x];
				int v3 = matrix[n - 1 - x][n - 1 - y];
				int v4 = matrix[n - 1 - y][x];
				matrix[y][n - 1 - x] = v1;
				matrix[n - 1 - x][n - 1 - y] = v2;
				matrix[n - 1 - y][x] = v3;
				matrix[x][y] = v4;
				visited[x][y] = true;
				visited[y][n - 1 - x] = true;
				visited[n - 1 - x][n - 1 - y] = true;
				visited[n - 1 - y][x] = true;
			}
		}

	}
}
