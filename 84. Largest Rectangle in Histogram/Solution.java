import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];  // To store the left boundary of each bar
        int[] right = new int[n]; // To store the right boundary of each bar
        Stack<Integer> stack = new Stack<>(); // Stack to maintain indices

        // Calculate the left boundaries for each bar
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop(); // Pop until we find a smaller height
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        // Clear the stack and calculate the right boundaries for each bar
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop(); // Pop until we find a smaller height
            }
            right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }

        int maxArea = 0;

        // Calculate the maximum area for each bar
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] + 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
