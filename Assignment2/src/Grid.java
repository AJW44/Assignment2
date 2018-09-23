/**
*
* The grid represents the game board.
*
*/

public class Grid {

	// Define the amount of rows and columns
	static int ROWS = 3; // Rows
	static int COLUMNS = 3; // Columns
	static Box[][] board; // Represents the game board as a grid
	int currentRow; // Row that was played last
	int currentCol; // Column that was played last
	public static final int EMPTY = 0;
	public static final int CROSS = 1;
	public static final int NOUGHT = 2;
	
/**
*
* Constructor
*
*/
	public Grid() {

		board = new Box[ROWS][COLUMNS]; // TODO: Initialise the board array using ROWS and COLUMN

			for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLUMNS; ++col) {
				board[row][col] = new Box(row, col);
			}
		}
	}

/**
*
* Checks if the game has ended in a draw
*
* One way to do this is to check that there are no empty positions left
*
*/
	public boolean isDraw() {

		for (int row = 0; row < ROWS; ++row) {						// Hint: Use a nested loop (see the constructor for an example). Check whether any of the Boxes in the board grid are Player.Empty. If they are, it is not a draw.
		for (int col = 0; col < COLUMNS; ++col) {					// Hint: Return false if it is not a draw, return true if there are not empty positions left

			if (board[row][col].content == Player.EMPTY) {

				return false;
			}
		}
	}
		return true;
	}

/**
*
* Return true if the turn player has won after making their move at the coordinate given
*
*/

	public boolean hasWon(Player player) {

		// Row check
		if (board[currentRow][0].content == player && board[currentRow][1].content == player && board[currentRow][2].content == player) {

			return true;
		}
		// Column check
		if (board[0][currentCol].content == player && board[1][currentCol].content == player && board[2][currentCol].content == player) {				// TODO: Check if the currentCol is filled.
																																						// Hint: Use the row code above as a starting point, remember that it goes board[row][column].
			return true;
		}
		// Diagonal check (check both directions
		if (board[0][0].content == player && board[1][1].content == player && board[2][2].content == player) {

			return true;
		}
		// TODO: Check the diagonal in the other direction
		if (board[0][2].content == player && board[1][1].content == player && board[2][0].content == player) {

			return true;
		}
		// No one has won yet

			return false;
		}
/**
*
* Draws the tic-tac-toe board to the screen
*
*/

	public static void display() {

		for (int row = 0; row < ROWS; ++row) {
		for (int col = 0; col < COLUMNS; ++col) {

		// Draw the contents of the box
		board[row][col].display();

		if (col != COLUMNS - 1) {
			// Draw the vertical line
			System.out.print(" | ");
		}
	}
	System.out.println();

		if (row != ROWS - 1) {
			// Draw the horizontal line
			System.out.println("-----------");
		}
	}
	System.out.println();
	}
}
	