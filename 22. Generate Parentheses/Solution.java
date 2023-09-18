import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, "", 0, 0, n);
        return result;
    }

    private void generateParenthesisHelper(List<String> result, String current, int open, int close, int n) {
        // Base case: If the current string has reached the desired length, add it to the result.
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Recursive case 1: Add an open parenthesis if the count of open parentheses is less than n.
        if (open < n) {
            generateParenthesisHelper(result, current + "(", open + 1, close, n);
        }

        // Recursive case 2: Add a close parenthesis if the count of close parentheses is less than open.
        if (close < open) {
            generateParenthesisHelper(result, current + ")", open, close + 1, n);
        }
    }
}
