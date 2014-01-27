package Jan;

import java.util.ArrayList;

public class ValidSudoku {
	public static void main(String args[]){
		String[] strs={".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		char[][]board=new char[9][9];
		for(int i=0;i<9;i++){
			board[i]=strs[i].toCharArray();
		}
		ValidSudoku v=new ValidSudoku();
		boolean re=v.isValidSudoku(board);
		System.out.println(re);
	}

	public boolean isValidSudoku(char[][] board) {
		// rule 1
		// check heng
		for (int i = 0; i < 9; i++) {
			char[] line = board[i];
			if (isValid(line) == false) {
				System.out.println("Heng:"+i);
				return false;
			}
		}
		// rule 2
		// check shu
		for (int i = 0; i < 9; i++) {
			char[] line = new char[9];
			for (int j = 0; j < 9; j++) {
				line[j] = board[j][i];
			}
			if (isValid(line) == false) {
				System.out.println("Shu:"+i);
				return false;
			}
		}

		// rule 3
		// check each square
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				char[] line = new char[9];
				for (int k = 0; k < 9; k++) {
					line[k] = board[3 * i + k / 3][3 * j + k % 3];
				}
				if (isValid(line) == false) {
					System.out.println("I:"+i+", J:"+j);
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[] line) {
		ArrayList<Character> tmp = new ArrayList<Character>();
		for (int i = 0; i < 9; i++) {
			char ch = line[i];
			if (ch != '.') {
				if (tmp.contains(ch)) {
					return false;
				} else {
					tmp.add(ch);
				}
			}
		}
		return true;
	}
}
