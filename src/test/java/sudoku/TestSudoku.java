package sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestSudoku {

	String[][] s = new String[4][4];

	@Before
	public void setup() {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				s[i][j] = Sudoku.EMPTY;
			}
		}

		s[0][1] = "1";
		s[0][2] = "3";
		s[1][3] = "4";
		s[2][0] = "1";
		s[3][1] = "2";
		s[3][2] = "4";
	}

	@Test
	public void testSudoku() {
		Sudoku sudoku = new Sudoku(s);
		sudoku.solve();
		String expectedResult = " 4  1  |  3  2 \n" +
				" 2  3  |  1  4 \n" +
				"--------------\n" +
				" 1  4  |  2  3 \n" +
				" 3  2  |  4  1 \n";

		Assert.assertEquals(expectedResult, sudoku.getAnswer());
	}

}
