Certainly! Let's break down the `evalRPN` method in detail:

```java
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
```

Here's a step-by-step explanation of how this code evaluates expressions in Reverse Polish Notation (RPN):

1. Initialize a `Stack<Integer>` named `stack`. This stack will be used to store operands as we evaluate the RPN expression.

2. Loop through each token in the `tokens` array, where a token can be an operator (+, -, *, /) or an operand (a number).

3. For each token, check if it's a number using the regular expression `token.matches("-?\\d+")`. If it's a number (either positive or negative), parse it into an integer and push it onto the `stack`. Numbers are operands, so we directly push them onto the stack.

4. If the token is an operator, perform the following steps:
   a. Pop the top two integers from the `stack`. These two integers are the operands for the operator.
   b. Perform the operation based on the operator:
    - If the operator is "+", add `operand1` and `operand2` and store the result in `result`.
    - If the operator is "-", subtract `operand2` from `operand1` and store the result in `result`.
    - If the operator is "*", multiply `operand1` and `operand2` and store the result in `result`.
    - If the operator is "/", divide `operand1` by `operand2` and store the result in `result`.
      c. Push the `result` back onto the `stack`. Now, the `stack` contains the result of the operation.

5. Continue this process for all tokens in the input array, and the final result will be the only element left on the `stack`.

6. Return the result obtained by popping the final value from the `stack`. This is the evaluated result of the RPN expression.

This code correctly evaluates RPN expressions, handling both operands and operators and ensuring that division by zero is handled explicitly to avoid errors.