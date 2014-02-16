package February;

import java.util.ArrayList;

public class SudokuSolver {

	public static void main(String args[]) {
		char board[][] = new char[9][9];
		board[0] = "..9748...".toCharArray();
		board[1] = "7........".toCharArray();
		board[2] = ".2.1.9...".toCharArray();
		board[3] = "..7...24.".toCharArray();
		board[4] = ".64.1.59.".toCharArray();
		board[5] = ".98...3..".toCharArray();
		board[6] = "...8.3.2.".toCharArray();
		board[7] = "........6".toCharArray();
		board[8] = "...2759..".toCharArray();
		// for (int i = 0; i < 9; i++) {
		// for (int j = 0; j < 9; j++) {
		// board[i][j] = '.';
		// }
		// }
		new SudokuSolver().solveSudoku(board);
	}

	private char[][] result;
	private boolean finished;

	public void solveSudoku(char[][] board) {
		finished = false;
		result = new char[9][9];
		process(board, 0, 0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = result[i][j];
			}
		}
		for (char[] c : board)
			System.out.println(c);
	}

	private void process(char[][] board, int i, int j) {
		if (i >= 9) {
			finished = true;
			result = board;
			return;
		}
		int newi = i;
		int newj = j + 1;
		if (j == 8) {
			newi++;
			newj = 0;
		}
		if (board[i][j] != '.') {
			process(board, newi, newj);
			return;
		}
		ArrayList<Character> list = get(board, i, j);
		if (list.size() == 0 || finished == true) {
			return;
		}

		for (char c : list) {
			char[][] newarray = new char[9][9];
			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++) {
					newarray[x][y] = board[x][y];
				}
			}
			newarray[i][j] = c;
			process(newarray, newi, newj);

		}
	}

	private ArrayList<Character> get(char[][] board, int i, int j) {
		ArrayList<Character> list = new ArrayList<>();
		if (i >= 9 || j >= 9 || board[i][j] != '.') {
			return list;
		}
		for (char c = '9'; c >= '1'; c--) {
			list.add(c);
		}
		// horizontal and vertical check
		for (int c = 0; c < 9; c++) {
			char h = board[i][c];
			char v = board[c][j];
			if (list.contains(h)) {
				list.remove(new Character(h));
			}
			if (list.contains(v)) {
				list.remove(new Character(v));
			}
		}
		int si = i / 3 * 3;
		int sj = j / 3 * 3;
		for (int x = si; x < 3; x++) {
			for (int y = sj; y < 3; y++) {
				char xy = board[x][y];
				if (list.contains(xy)) {
					list.remove(new Character(xy));
				}
			}
		}
		return list;
	}
}
