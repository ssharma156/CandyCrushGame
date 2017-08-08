import java.util.Scanner;

public class TicTacToeBoard {
	static int nOofTilesFilled;
	static char[][] toeArr = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
	static boolean[][] containsValue = { { false, false, false }, { false, false, false }, { false, false, false } };
	static boolean inserted = false;

	static void swap(int[][] arr, int i, int j, int m, int n){
		int temp;
		temp = arr[i][j];
		arr[i][j] = arr[m][n];
		arr[m][n] = temp;
	}

	public static boolean checkAndSet(int i, int j, char mark) {
		inserted = false;
		if (toeArr[i][j] == ' ') {
			// if (toeArr[i][j] != mark){
			toeArr[i][j] = mark;
			containsValue[i][j] = true;
			nOofTilesFilled++;
			inserted = true;
			// }
		}
		return inserted;
	}

	//Sourabh Method
	public static boolean set(int cellNum, char mark) {
//		System.out.println("@set method call");
		int n = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				n++;
				if (n == cellNum){
					if(checkAndSet(i, j, mark))
						return checkWinner(toeArr, i, j);
				}
			}
		}
		return false;
	}

	public static boolean checkWinner(char[][] toeArr, int i, int j) {
		char[][] arr = toeArr;
//		int[][] grr = new int[3][3];
		int numi = 0;
		int numj = 0;

		// row check
		for (int x = 0; x < 3; x++) {
			if (arr[i][j] == arr[i][x])
				numi++;
			if (numi == 3) {
				System.out.println("We have a winner! :-) ");
				return true;
			}
		}

		// column check
		for (int y = 0; y < 3; y++) {
			if (arr[i][j] == arr[y][j])
				numj++;
			if (numj == 3) {
				System.out.println("We have a winner! :-) ");
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
					System.out.println("We have a winner! :-) ");
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
				System.out.println("We have a winner! :-) ");
				return true;
			}
		}
		/*if(nOofTilesFilled == 9){
			TicTacToeBoard.drawBoard();
			System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\nGame ended, but no winner. Better luck.\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.exit(0);
		}*/

		return false;
	}

	public static void drawBoard() {
		System.out.println("+---+---+---+");
		System.out.println("| " + toeArr[0][0] + " | " + toeArr[0][1] + " | " + toeArr[0][2] + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + toeArr[1][0] + " | " + toeArr[1][1] + " | " + toeArr[1][2] + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + toeArr[2][0] + " | " + toeArr[2][1] + " | " + toeArr[2][2] + " |");
		System.out.println("+---+---+---+");
	}


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// Empty Board
		TicTacToeBoard.drawBoard();
		boolean haveWinner = false;

		do{
			System.out.print("Enter cell num to add mark to: ");
			haveWinner = set(scn.nextInt(), 'X');
			TicTacToeBoard.drawBoard();
		}while(!haveWinner);


	}
}
