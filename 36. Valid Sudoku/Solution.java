import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create sets to store seen digits in rows, columns, and 3x3 sub-boxes
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Iterate through the board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char current = board[row][col];

                // Skip empty cells
                if (current == '.') {
                    continue;
                }

                // Check row
                if (!rows[row].add(current)) {
                    return false;
                }

                // Check column
                if (!cols[col].add(current)) {
                    return false;
                }

                // Check 3x3 sub-box
                int boxIndex = (row / 3) * 3 + col / 3;
                if (!boxes[boxIndex].add(current)) {
                    return false;
                }
            }
        }

        return true; // The board is valid
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(solution.isValidSudoku(board1)); // Output: true
        System.out.println(solution.isValidSudoku(board2)); // Output: false
    }
}
