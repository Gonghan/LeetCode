package Jan;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int width = grid.length;
		if (width == 0) {
			return 0;
		}
		int height = grid[0].length;
		if (height == 0) {
			return 0;
		}
		int minSubSum[][] = new int[width][height];

		minSubSum[0][0] = grid[0][0];
		for (int i = 1; i < width; i++) {
			minSubSum[i][0] = grid[i][0] + minSubSum[i - 1][0];
		}

		for (int i = 1; i < height; i++) {
			minSubSum[0][i] = grid[0][i] + minSubSum[0][i - 1];
		}

		for (int i = 1; i < width; i++) {
			for (int j = 1; j < height; j++) {
				minSubSum[i][j] = Math.min(minSubSum[i - 1][j],
						minSubSum[i][j - 1]) + grid[i][j];
			}
		}

		return minSubSum[width - 1][height - 1];
	}
}
