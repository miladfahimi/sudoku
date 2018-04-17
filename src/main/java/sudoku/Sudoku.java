package sudoku;

public class Sudoku {
	private String[][] sudoku;
	public static final String EMPTY = "_";

	public Sudoku(String[][] sudoku) {
		this.sudoku = sudoku;
	}

	public boolean solve() {
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				if (EMPTY.equals(sudoku[row][col])) {
					for (int number = 1; number <= 4; number++) {
						String num = Integer.toString(number);
						if (isAllowed(row, col, num)) {
							sudoku[row][col] = num;
							if (solve()) {
								return true;
							} else {
								sudoku[row][col] = EMPTY;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isInRow(int row, String number) {
		for (int i = 0; i < 4; i++) {
			if (number.equals(sudoku[row][i])) {
				return true;
			}
		}
		return false;
	}

	private boolean isInColumn(int col, String number) {
		for (int i = 0; i < 4; i++) {
			if (number.equals(sudoku[i][col])) {
				return true;
			}
		}
		return false;
	}

	private boolean isInBox(int row, int col, String number) {
		int boxRow = row - row % 2;
		int boxCol = col - col % 2;
		for (int i = boxRow; i < boxRow + 2; i++) {
			for (int j = boxCol; j < boxCol + 2; j++) {
				if (number.equals(sudoku[i][j])) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isAllowed(int row, int col, String number) {
		return !(isInRow(row, number) || isInColumn(col, number) || isInBox(row, col, number));
	}

	public String getAnswer() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0 && i != 0) {
				result.append("--------------\n");
			}
			for (int j = 0; j < 4; j++) {
				if (j % 2 == 0 && j != 0) {
					result.append(" | ");
				}
				result.append(" " + sudoku[i][j] + " ");

			}
			result.append("\n");
		}
		return result.toString();
	}
}
