import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                // If the token is a number (positive or negative), push it onto the stack.
                stack.push(Integer.parseInt(token));
            } else {
                // If the token is an operator, pop the top two numbers from the stack and apply the operator.
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                int result = 0;
                if (token.equals("+")) {
                    result = operand1 + operand2;
                } else if (token.equals("-")) {
                    result = operand1 - operand2;
                } else if (token.equals("*")) {
                    result = operand1 * operand2;
                } else {
                    // Handle division by zero explicitly to avoid errors.
                    if (operand2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result = operand1 / operand2;
                }

                // Push the result back onto the stack.
                stack.push(result);
            }
        }

        // The final result should be the only element left on the stack.
        return stack.pop();
    }
}
