import java.util.*;

public class Sudoku {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] grid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        }; // hard code a 9 * 9 grid

        do {
            display_grid(grid); // display the grid

            // ask for coordinates where user wants to make a change
            System.out.println("Enter the row you want to change: ");
            int row = input.nextInt();
            System.out.println("Enter the col you want to change: ");
            int col = input.nextInt();
            do {
                System.out.println("Enter a number between 1 and 9: ");
                grid[row][col] = input.nextInt();
            } while (grid[row][col] < 1 || grid[row][col] > 9); // check number is between 1 and 9 inclusive
            // call methods to validate rows, columns and sub grids
            if (!row(grid, row, col) || !col(grid, row, col) || !sub_grid(grid, row, col)) {
                grid[row][col] = 0;
                System.out.println("Sorry! This number is not valid");
            } // if number is invalid set the element back to 0
        } while (!solution(grid)); // continue the process until answer is correct
        System.out.println("Congratulations you got it!");

        display_grid(grid);
    }

    public static boolean row(int[][] arr, int row, int col) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (arr[row][col] == arr[i][col]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    } // checks that the number entered does not already exist in that row

    public static boolean col(int[][] arr, int row, int col) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (arr[row][col] == arr[row][i]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    } // checks that the number entered does not already exist in that column

    public static boolean sub_grid(int[][] arr, int row, int col) {
        int count = 0;
        for (int i = ((row / 3) * 3); i <= (((row / 3) * 3) + 2); i++) {
            for (int j = ((col / 3) * 3); j <= (((col / 3) * 3) + 2); j++) {
                if (arr[row][col] == arr[i][j]) {
                    count++;
                }
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    } // checks that the number entered does not already exist in that subgrid
    
    public static boolean rowsol(int[][] arr) {
        for (int i = 1; i <= 9; i++) {
            for (int row = 0; row <= 8; row++) {
                int count = 0;
                for (int col = 0; col <= 8; col++) {
                    if (arr[row][col] == i) {
                        count++;
                    }
                }
                if (count != 1)
                    return false;
            }
        }
        return true;
    } // checks that each number exists only once in each row
    
    public static boolean colsol(int[][] arr) {
        for (int i = 1; i <= 9; i++) {
            for (int col = 0; col <= 8; col++) {
                int count = 0;
                for (int row = 0; row <= 8; row++) {
                    if (arr[row][col] == i) {
                        count++;
                    }
                }
                if (count != 1)
                    return false;
            }
        }
        return true;
    } // checks that each number exists only once in each column
    
    public static boolean subgridsol(int[][] arr) {
        for (int k = 1; k <= 9; k++) {
            for (int l = 0; l < 2; l++) {
                int count = 0;
                for (int i = (l * 3); i <= ((l * 3) + 2); i++) {
                    for (int j = (l * 3); j <= ((l * 3) + 2); j++) {
                        if (arr[i][j] == k) {
                            count++;
                        }
                    }
                }
                if (count != 1) {
                    return false;
                }
            }
        }
        return true;
    } // checks that each number exists only once in each sub grid
    
    public static boolean solution(int[][] arr) {
        return (rowsol(arr) && colsol(arr) && subgridsol(arr));
    } // checks that each number is in its correct position
    public static void display_grid(int[][] arr) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    } // displays grid with spaces for clarity
}
