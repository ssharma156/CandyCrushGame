import java.util.Arrays;
import java.util.Scanner;

public class CandyCrush {

	static char[][] cells = TicTacToeBoard.toeArr;

	char[] marks;
	int randomIndex;
	int num1, num2;
	Scanner scn;
	int score;

	CandyCrush(){
		scn = new Scanner(System.in);
		marks = new char[]{'O', 'X', 'Y', 'V', 'T'};
		score = 0;
	}

	public void fillRandom(){
		for(int i=0; i<cells.length; i++){
			for(int j=0; j<cells[0].length; j++){
				randomIndex = (int) (Math.random() * marks.length);
				cells[i][j] = marks[randomIndex];
			}
		}
	}

	public void takeInput() {
		System.out.print("\nEnter cell numbers to swap(seperated by space): ");
		try {
			num1 = scn.nextInt();
			num2 = scn.nextInt();

			if(num1 < 1 && num1 > 9 || num2 < 1 && num2 > 9){
				throw new Exception();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Only integers are allowed\n");
			takeInput();
		}
		catch(Exception e){
			System.out.println("1 to 9 integers allowed\n");
			takeInput();
		}
	}


	/*
	 * ###################################
	 *          Meghana's Logic
	 * ###################################
	 */
	static void swap(int firstCellNum, int lastCellNum){
		int i, j, m, n;

		i = (firstCellNum % 3 == 0) ? firstCellNum / 3 - 1 : firstCellNum / 3;
		j = (firstCellNum % 3 == 0) ? 2 : firstCellNum % 3 - 1;

		m = (lastCellNum % 3 == 0) ? lastCellNum / 3 - 1 : lastCellNum / 3;
		n = (lastCellNum % 3 == 0) ? 2 : lastCellNum % 3 - 1;


			if (j == n) { // same column
				if (i == m + 1 || i == m - 1) {
					// swap(arr, i, j, m, n)
					swap(cells, i, j, m, n);
				}
			} else
			 if (i == m) { // same row
				if (j == n + 1 || j == n - 1) {
					// swap(arr, i, j, m, n)
					swap(cells, i, j, m, n);
				}
				// not required as such
			} else
			 /*if (i == j && m == n) { // on same diagonal
				if (i == m + 1 || i == m - 1) {
					// swap(arr, i, j, m, n)
					swap(cells, i, j, m, n);
				}
				// not required as such.
			} else
			 if ((i == m + 1 || i == m - 1) && (j == n + 1 || j == n - 1)) {
				// swap(arr, i, j, m, n)
				 swap(cells, i, j, m, n);

			} else*/
				System.out.println("value not swapped");
	}

	static boolean rowOrColumn(int num) {
		int i = (num % 3 != 0) ? num / 3 : num / 3 - 1;
		int j = (num % 3 != 0) ? num % 3 - 1 : 3 - 1;
		char[][] arr = cells;
//		int[][] grr = new int[3][3];
		int numi = 0;
		int numj = 0;

		// row check
		for (int x = 0; x < 3; x++) {
			if (arr[i][j] == arr[i][x])
				numi++;
			if (numi == 3) {
				return true;
			}
		}

		// column check
		for (int y = 0; y < 3; y++) {
			if (arr[i][j] == arr[y][j])
				numj++;
			if (numj == 3) {
				return true;
			}
		}
		// diagonal 1 [0,0] to [2,2]
		int numd = 0;
		if (i == j)// if begins(outer)
		{
			for (int z = 0; z < 3; z++) {
				if (arr[i][j] == arr[z][z])
					numd++;
				if (numd == 3) {
					return true;
				}
			}
		} // if ends(outer)

		// diagonal 2 [0,2] to [2,0]
//		int y = 2;
		int numd2 = 0;
		for (int x = 0, y = 2; x < 3; x++, y--) {
			if (arr[i][j] == arr[x][y])
				numd2++;
			if (numd2 == 3) {
				return true;
			}
		}
		/*if(nOofTilesFilled == 9){
			TicTacToeBoard.drawBoard();
			System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\nGame ended, but no winner. Better luck.\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.exit(0);
		}*/

		return false;
		/*return TicTacToeBoard.checkWinner(cells, (num % 3 != 0) ? num / 3 : num / 3 - 1,
				(num % 3 != 0) ? num % 3 - 1 : 3 - 1);*/
	}
	static void swap(char[][] arr, int i, int j, int m, int n){
		char temp;
		temp = arr[i][j];
		arr[i][j] = arr[m][n];
		arr[m][n] = temp;
	}
}
