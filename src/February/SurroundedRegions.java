package February;

public class SurroundedRegions {

	public static void main(String args[]) {
		SurroundedRegions s = new SurroundedRegions();
		char[][] board = { 
				{ 'X', 'X', 'X', 'X' }, 
				{ 'X', 'O', 'O', 'X' },
				{ 'X', 'X', 'O', 'X' }, 
				{ 'X', 'O', 'X', 'X' } };
		s.solve(board);
		for(char[]c:board){
			System.out.println(c);
		}
	}

	
	private int height;
	private int width;
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		height = board.length;
		width = board[0].length;
		if (height == 1 || width == 1) {
			return;
		}
		for (int i = 0; i < height; i++) {
			// left, right border
			// left: [i,0]
			// right: [i,width-1]
			if (board[i][0] == 'O') {
				bfs(board, i, 0);
			}
			if (board[i][width - 1] == 'O') {
				bfs(board, i, width - 1);
			}
		}
		for (int i = 0; i < width; i++) {
			// up, low border
			// up: [0,i]
			// low: [height-1,i]
			if (board[0][i] == 'O') {
				bfs(board, 0, i);
			}
			if (board[height - 1][i] == 'O') {
				bfs(board, height - 1, i);
			}
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == 'Y') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void bfs(char[][] board, int i, int j) {
		if (i >= height || i < 0 || j < 0 || j >= width) {
			return;
		}
		if (board[i][j] != 'O') {
			return;
		}
		board[i][j] = 'Y';
		if(j+1<width && board[i][j+1]=='O'){
			bfs(board,i,j+1);
		}
		if (i+1<height && board[i+1][j]=='O') {
			bfs(board, i + 1, j);
		}
		if (i-1>=0 && board[i-1][j]=='O') {
			bfs(board, i - 1, j);
		}
		if (j-1>0 && board[i][j-1]=='O') {
			bfs(board, i, j - 1);
		}
	}
}
