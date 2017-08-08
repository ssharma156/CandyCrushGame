public class CandyCrushTest {
	public static void main(String[] args) {

		CandyCrush cc = new CandyCrush();
		// Preparing random board...
		cc.fillRandom();
		TicTacToeBoard.drawBoard();
		// Random board ready!

		while (true) {
			int turnScore = 0;
			boolean isMatch = false;
			// Taking input...
			cc.takeInput();
			// Input taken!

			// Swapping...
			System.out.println("\nSwapping...\n");
			CandyCrush.swap(cc.num1, cc.num2);
			// Swapped.


			if(cc.rowOrColumn(cc.num1)) {
				turnScore += 1;
				++cc.score;
				isMatch = true;
			}
			if(cc.rowOrColumn(cc.num2)) {
				turnScore += 1;
				++cc.score;
				isMatch = true;
			}
			System.out.println("\n## Score obtained in this turn " + turnScore + " ##");
			System.out.println("** Total Score so far " + cc.score + " **\n");

			if(isMatch) cc.fillRandom();
			TicTacToeBoard.drawBoard();
		}
	}
}
