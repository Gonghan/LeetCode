package February;

/*
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 */
public class UniquePathsII {

	public static void main(String args[]) {
		UniquePathsII u=new UniquePathsII();
		int grid[][]={{0,0,0},{0,0,0},{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(u.uniquePathsWithObstacles(grid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int cache[][] = new int[111][111];
		if (obstacleGrid == null || obstacleGrid.length == 0
				|| obstacleGrid[0].length == 0) {
			return 0;
		}
		if (obstacleGrid[0][0] != 0) {
			return 0;
		} else {
			cache[0][0] = 1;
		}
		int height = obstacleGrid.length;
		int width = obstacleGrid[0].length;
		for (int i = 1; i < height; i++) {
			if (obstacleGrid[i][0] == 0) {
				cache[i][0] = cache[i - 1][0];
			}
		}
		for (int i = 1; i < width; i++) {
			if (obstacleGrid[0][i] == 0) {
				cache[0][i] = cache[0][i - 1];
			}
		}

		for (int i = 1; i < height; i++) {
			for (int j = 1; j < width; j++) {
				if (obstacleGrid[i][j] == 1) {
					cache[i][j] = 0;
				} else {
					cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
				}
			}
		}
		return cache[height - 1][width - 1];
	}
}
