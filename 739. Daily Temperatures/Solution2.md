Overview
In this problem, we are given a list of temperatures where the temperature at index iii represents the temperature of the ithi^{th}i
th
day. Our goal is to, for each day, find the number of days until the next day that is warmer than the current day. Often, the best place to start solving a problem is by considering a brute-force approach. The naive/brute-force way to solve this problem is to iterate through the array, and for each day, iterate through all of the remaining days until you find a warmer temperature. This approach would have a time complexity of O(N2)O(N^2)O(N
2
), which is very slow given the constraints N<105N < 10^5N<10
5
. What makes brute-force so inefficient?


Imagine if you had multiple days in a row with a decreasing temperature, and then one very hot day - [40, 39, 38, 37, 36, 35, 34, 65]. The final day is the "answer" day for all the other days. Why? Because all the other days are in descending order (and cooler than the last day). If we make use of the fact that temperatures in descending order can share the same "answer" day, we can improve the time complexity.

In the above example, we can "delay" finding the answer for the first 7 days, and upon finding a warmer temperature 65, we can move backward to find the answer for all 7 days at the same time. This process of storing elements and then walking back through them matches the behavior of a stack.

Approach 1: Monotonic Stack
Intuition

Let's look at a data structure known as a Monotonic Stack. A monotonic stack is simply a stack where the elements are always in sorted order. How does this help us? We can use a monotonic decreasing stack to hold temperatures. Monotonic decreasing means that the stack will always be sorted in descending order. Because the problem is asking for the number of days, instead of storing the temperatures themselves, we should store the indices of the days, and use temperatures[i] to find the temperature of the ithi^{th}i
th
day.

Monotonic stacks are a good option when a problem involves comparing the size of numeric elements, with their order being relevant.

On each day, there are two possibilities. If the current day's temperature is not warmer than the temperature on the top of the stack, we can just push the current day onto the stack - since it is not as warm (equal or smaller), this will maintain the sorted property.

If the current day's temperature is warmer than the temperature on top of the stack, this is significant. It means that the current day is the first day with a warmer temperature than the day associated with the temperature on top of the stack. When we find a warmer temperature, the number of days is the difference between the current index and the index on the top of the stack. We can declare an answer array before iterating through the input and populate answer as we go along.

When we find a warmer temperature, we can't stop after checking only one element at the top. Using the example temperatures = [75, 71, 69, 72], once we arrive at the last day our stack looks like stack = [0, 1, 2]. For clarity, here's what the stack looks like with each temperature associated with the day: stack = [(0, 75), (1, 71), (2, 69)]. 72 (the current temperature) is greater than 69, but it is also greater than 71. To make sure we don't miss any days, we should pop from the stack until the top of the stack is no longer colder than the current temperature. Once that is the case, we can push the current day onto the stack.

Algorithm

Initialize an array answer with the same length as temperatures and all values initially set to 0. Also, initialize a stack as an empty array.

Iterate through temperatures. At each index currDay:

If the stack is not empty, that means there are previous days for which we have not yet seen a warmer day. While the current temperature is warmer than the temperature of prevDay (the index of the day at the top of the stack):
Set answer[prevDay] equal to the number of days that have passed between prevDay and the current day, that is, answer[prevDay] = currDay - prevDay.
Push the current index currDay onto the stack.
Return answer.

Here's an example animation showing how this algorithm works. For clarity, temperatures of the days are included with the indices:

Current


Implementation


Complexity Analysis

Given NNN as the length of temperatures,

Time complexity: O(N)O(N)O(N)

At first glance, it may look like the time complexity of this algorithm should be O(N2)O(N^2)O(N
2
), because there is a nested while loop inside the for loop. However, each element can only be added to the stack once, which means the stack is limited to NNN pops. Every iteration of the while loop uses 1 pop, which means the while loop will not iterate more than NNN times in total, across all iterations of the for loop.

An easier way to think about this is that in the worst case, every element will be pushed and popped once. This gives a time complexity of O(2⋅N)=O(N)O(2 \cdot N) = O(N)O(2⋅N)=O(N).

Space complexity: O(N)O(N)O(N)

If the input was non-increasing, then no element would ever be popped from the stack, and the stack would grow to a size of N elements at the end.

Note: answer does not count towards the space complexity because space used for the output format does not count.