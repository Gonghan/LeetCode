package Jan;

public class SurroundedRegions {
	
	public static void main(String args[]){
		SurroundedRegions sr=new SurroundedRegions();
		char[][]board={"XOXX".toCharArray(),"OXOX".toCharArray(),"XOXO".toCharArray(),"OXOX".toCharArray(),"XOXO".toCharArray(),"OXOX".toCharArray()};
		sr.solve(board);
	}

	private int height;
	private int width;

	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0] == null) {
			return;
		}
		height = board.length;
		width = board[0].length;

		// 0=X or will be converted into X
		// 1=remain as O
		int freeO[][] = new int[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i][j] != 'O') {
					continue;
				}
				// check position
				int pos = checkPos(i, j);
				if (pos != 0) {
					continue;
				}
				// freeO[i][j]=1;
				extend(i, j, freeO, board);

			}
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (freeO[i][j] == 0) {
					board[i][j] = 'X';
				} else {
					board[i][j] = 'O';
				}
			}
		}
	}

	// 1=inside
	// 0=border
	// -1=outside
	private int checkPos(int x, int y) {
		if (x > 0 && x < height - 1 && y > 0 && y < width - 1) {
			return 1;
		}
		if (x < 0 || x > height - 1 || y < 0 || y > width - 1) {
			return -1;
		}
		return 0;
	}

	private void extend(int i, int j, int[][] freeO, char[][] board) {
		int pos = checkPos(i, j);
		if (pos == -1) {
			return;
		}
		if (board[i][j] == 'X') {
			return;
		}
		if (freeO[i][j] == 1) {
			return;
		}
		freeO[i][j] = 1;
		// top
		extend(i - 1, j, freeO, board);
		// down
		extend(i + 1, j, freeO, board);
		// left
		extend(i, j - 1, freeO, board);
		// right
		extend(i, j + 1, freeO, board);
	}
}
