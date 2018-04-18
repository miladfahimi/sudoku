package sudoku;

import java.util.Random;

public class gameGenerator {

	private Sudoku sudok;
	private String[][] game;

	public gameGenerator() {

		String[][] s = new String[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				s[i][j] = Sudoku.EMPTY;
			}
		}

		String rnd1 = Integer.toString(new Random().nextInt(4) + 1);
		String rnd2 = Integer.toString(new Random().nextInt(4) + 1);

		s[0][0] = rnd1;
		s[3][3] = rnd2;
		s[1][2] = rnd1;
		s[2][1] = rnd2;
		
		sudok = new Sudoku(s);
		sudok.solve();

		game = sudok.getTable();

		int hideAnswer = 0;
		while (hideAnswer < 12) {
			int rand1 = new Random().nextInt(4);
			int rand2 = new Random().nextInt(4);
			game[rand1][rand2] = Sudoku.EMPTY;
			hideAnswer++;
		}
	}

	public String getTable() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0 && i != 0) {
				result.append("--------------\n");
			}
			for (int j = 0; j < 4; j++) {
				if (j % 2 == 0 && j != 0) {
					result.append(" | ");
				}
				result.append(" " + game[i][j] + " ");

			}
			result.append("\n");
		}
		return result.toString();
	}

	public void updateValue(int row, int col, int value) {
		String v = Integer.toString(value);
		game[row][col] = v;
	}

	public String[][] getGame() {
		return game;
	}
}
