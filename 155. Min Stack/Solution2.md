Approach 1: Stack of Value/ Minimum Pairs
Intuition

An invariant is something that is always true or consistent. You should always be on the lookout for useful invariants when problem-solving in math and computer science.

Recall that with a Stack, we only ever add (push) and remove (pop) numbers from the top. Therefore, an important invariant of a Stack is that when a new number, which we'll call x, is placed on a Stack, the numbers below it will not change for as long as number x remains on the Stack. Numbers could come and go above x for the duration of x's presence, but never below.

So, whenever number x is the top of the Stack, the minimum will always be the same, as it's simply the minimum out of x and all the numbers below it.

Therefore, in addition to putting a number on an underlying Stack inside our MinStack, we could also put its corresponding minimum value alongside it. Then whenever that particular number is at the top of the underlying Stack, the getTop(...) operation of MinStack is as simple as retrieving its corresponding minimum value.

A stack of pairs built up.

So, how can we actually determine what the corresponding minimum for our new number is? (in (O(1)(O(1)(O(1) time). Have a look at the diagram above. All the minimum values are equal to either the minimum value immediately before, or the actual stack value alongside.

Where each minimum came from.

Therefore, when we put a new number on the underlying Stack, we need to decide whether the minimum at that point is the new number itself, or whether it's the minimum before. It makes sense that it would always be the smallest of these two values.

Here is an animation showing the entire algorithm described above.

Current

Algorithm

Note for Python: Recall that index -1 refers to the last item in in a list. i.e. self.stack[-1] in Python is equivalent to stack.peek() in Java and other languages.


Complexity Analysis

Let nnn be the total number of operations performed.

Time Complexity : O(1)O(1)O(1) for all operations.

push(...): Checking the top of a Stack, comparing numbers, and pushing to the top of a Stack (or adding to the end of an Array or List) are all O(1)O(1)O(1) operations. Therefore, this overall is an O(1)O(1)O(1) operation.

pop(...): Popping from a Stack (or removing from the end of an Array, or List) is an O(1)O(1)O(1) operation.

top(...): Looking at the top of a Stack is an O(1)O(1)O(1) operation.

getMin(...): Same as above. This operation is O(1)O(1)O(1) because we do not need to compare values to find it. If we had not kept track of it on the Stack, and instead had to search for it each time, the overall time complexity would have been O(n)O(n)O(n).

Space Complexity : O(n)O(n)O(n).

Worst case is that all the operations are push. In this case, there will be O(2⋅n)=O(n)O(2 \cdot n) = O(n)O(2⋅n)=O(n) space used.