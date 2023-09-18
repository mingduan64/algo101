import java.util.Set;

class Solution2 {
    private Set<String> operators = Set.of("+", "-", "*", "/");
    int lastIdx = 0;
    public int evalRPN(String[] tokens) {
        lastIdx = tokens.length - 1;
        return eval(tokens);
    }

    private int eval(String[] tokens) {
        if (lastIdx < 0) {
            return 0;
        }
        if (!operators.contains(tokens[lastIdx])) {
            return Integer.parseInt(tokens[lastIdx]);
        }

        String operator = tokens[lastIdx];
        lastIdx--;
        int num2 = eval(tokens);
        lastIdx--;
        int num1 = eval(tokens);
        int result;
        if (operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("*")) {
            result = num1 * num2;
        } else {
            result = num1 / num2;
        }
        return result;
    }
}