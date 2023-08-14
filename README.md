# Sudoku Solver Readme

This Java program provides a simple command-line interface to play and solve Sudoku puzzles. The program allows users to input their own numbers on the grid, and it verifies whether the numbers follow the rules of Sudoku. It also includes an automatic solver to solve the puzzle.

## How to Use

1. **Compilation**: Compile the `Sudoku.java` file using the Java compiler. You can use the following command in your terminal:

   ```sh
   javac Sudoku.java
   ```

2. **Execution**: Run the compiled program using the following command:

   ```sh
   java Sudoku
   ```

3. **Playing the Game**:
   - Upon starting the program, a 9x9 Sudoku grid with some initial values will be displayed.
   - You'll be prompted to enter coordinates (row and column) where you want to make a change.
   - You'll then be prompted to enter a number between 1 and 9 for the selected cell.
   - The program will validate whether the number fits the rules of Sudoku for the selected row, column, and sub-grid. If it's invalid, you'll be notified and asked to re-enter a number.
   - Continue making changes until you successfully complete the puzzle.

4. **Solving the Puzzle**:
   - The program includes an automatic solver that attempts to solve the Sudoku puzzle based on the rules of the game.
   - The solver uses three main validation functions: `rowsol`, `colsol`, and `subgridsol`, which ensure that each number from 1 to 9 appears only once in each row, column, and 3x3 sub-grid, respectively.
   - The `solution` function checks whether the puzzle is solved by verifying the results of these three validation functions.
   - If the puzzle is solved, the program will display a congratulatory message and the solved puzzle.

## Functions Overview

1. `row(int[][] arr, int row, int col)`: Checks if a number entered in a cell is valid within the row.
2. `col(int[][] arr, int row, int col)`: Checks if a number entered in a cell is valid within the column.
3. `sub_grid(int[][] arr, int row, int col)`: Checks if a number entered in a cell is valid within the 3x3 sub-grid.
4. `rowsol(int[][] arr)`: Checks if each number exists only once in each row.
5. `colsol(int[][] arr)`: Checks if each number exists only once in each column.
6. `subgridsol(int[][] arr)`: Checks if each number exists only once in each 3x3 sub-grid.
7. `solution(int[][] arr)`: Checks if the entire Sudoku puzzle is solved by validating rows, columns, and sub-grids.
8. `display_grid(int[][] arr)`: Displays the Sudoku grid with spaces for clarity.

## Note

This program provides a basic implementation of a Sudoku solver and game. More advanced Sudoku solving techniques, such as backtracking algorithms, are not included here. You might encounter limitations or cases where the solver is unable to determine a unique solution.

Feel free to use, modify, and learn from this code. If you're interested in enhancing the solver's capabilities or implementing additional features, you can explore various Sudoku solving algorithms and techniques.
