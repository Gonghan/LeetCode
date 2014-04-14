package February;

import java.util.ArrayList;

public class WordSearch {

	public static void main(String args[]) {
		WordSearch w = new WordSearch();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		String word = "SEET";
		boolean result = w.exist(board, word);
		System.out.println(result);
	}

	private int width;
	private int height;

	public boolean exist(char[][] board, String word) {
		if (word == null || word.isEmpty()) {
			return true;
		}
		if (board == null || board.length == 0 || board[0] == null
				|| board[0].length == 0) {
			return false;
		}
		width = board[0].length;
		height = board.length;
		char[] wordChars = word.toCharArray();
		boolean result = false;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				ArrayList<Integer> visited = new ArrayList<Integer>();
				result = result || process(board, wordChars, 0, i, j, visited);
				if (result == true) {
					return result;
				}
			}
		}
		return result;
	}

	// index: the position of char in word
	// x,y: the position of the char in board
	// visited: the array of nodes visied
	private boolean process(char[][] board, char[] word, int index, int x,
			int y, ArrayList<Integer> visited) {
		if (index >= word.length) {
			return true;
		}
		if (!validPos(x, y)) {
			return false;
		}
		char now = word[index];
		int code = getCode(x, y);
		if (now != board[x][y]) {
			return false;
		}
		if (visited.contains(code)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		ArrayList<Integer> newVisited = (ArrayList<Integer>) visited.clone();
		boolean result = false;
		newVisited.add(code);
		result = result
				|| process(board, word, index + 1, x + 1, y, newVisited);
		result = result
				|| process(board, word, index + 1, x - 1, y, newVisited);
		result = result
				|| process(board, word, index + 1, x, y + 1, newVisited);
		result = result
				|| process(board, word, index + 1, x, y - 1, newVisited);
		return result;
	}

	private boolean validPos(int x, int y) {
		if (x < 0 || x >= height) {
			return false;
		}
		if (y < 0 || y >= width) {
			return false;
		}
		return true;
	}

	// create a code(integer) to represent each position
	private int getCode(int x, int y) {
		return width * x + y;
	}
}
