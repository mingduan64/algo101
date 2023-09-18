Certainly! Let's break down the implementation of the `MinStack` class step by step:


    import java.util.Stack;

    class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }


1. Import the `Stack` class and declare the `MinStack` class.
    - The `MinStack` class uses two stacks: `mainStack` to store elements and `minStack` to keep track of the minimum values.
    - In the constructor (`MinStack()`), both `mainStack` and `minStack` are initialized as empty stacks.


    public void push(int val) {
        mainStack.push(val);

        // Update the minStack with the minimum value encountered so far.
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }


2. The `push` method:
    - Takes an integer value `val` as an argument and pushes it onto `mainStack` to store the element.
    - Checks whether `val` is less than or equal to the current minimum value stored in `minStack`. If it is, `val` is also pushed onto `minStack`. This ensures that `minStack` always contains the minimum element encountered so far.


    public void pop() {
        if (!mainStack.isEmpty()) {
            // If the element being removed from mainStack is the current minimum,
            // pop it from minStack as well to maintain accurate minimum values.
            if (mainStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            mainStack.pop();
        }
    }


3. The `pop` method:
    - Removes the top element from `mainStack` if it's not empty.
    - Checks whether the element being removed from `mainStack` is also the current minimum value (i.e., it matches the top element of `minStack`). If it does, it is also popped from `minStack`. This ensures that `minStack` always reflects the accurate minimum values.


    public int top() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        }
        throw new IllegalStateException("Stack is empty.");
    }


4. The `top` method:
    - Returns the top element of `mainStack` if `mainStack` is not empty.
    - Throws an `IllegalStateException` with the message "Stack is empty." if `mainStack` is empty.


    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new IllegalStateException("Stack is empty.");
    }
}


5. The `getMin` method:
    - Returns the top element of `minStack`, which represents the minimum value in the stack, if `minStack` is not empty.
    - Throws an `IllegalStateException` with the message "Stack is empty." if `minStack` is empty.

This implementation of `MinStack` ensures that you can efficiently perform push, pop, top, and getMin operations with a time complexity of O(1) for each operation, as required by the problem constraints. It keeps track of the minimum element in a separate stack (`minStack`), allowing for constant-time retrieval of the minimum value.