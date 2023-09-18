Sure, let's break down the binary search algorithm used in the `search` method in detail:

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;             // Initialize the left pointer to the start of the array.
        int right = nums.length - 1; // Initialize the right pointer to the end of the array.
        
        while (left <= right) {    // Perform binary search until left is less than or equal to right.
            int mid = left + (right - left) / 2; // Calculate the middle index.

            if (nums[mid] == target) {
                return mid; // If the middle element is equal to the target, return its index.
            } else if (nums[mid] < target) {
                left = mid + 1; // If the middle element is less than the target, search the right half.
            } else {
                right = mid - 1; // If the middle element is greater than the target, search the left half.
            }
        }
        
        return -1; // If the target is not found in the array, return -1.
    }
}
```

Now, let's go through each step in more detail:

1. **Initialization**: We start by initializing two pointers, `left` and `right`, which represent the current search range. `left` is set to the beginning of the array (index 0), and `right` is set to the end of the array (index `nums.length - 1`).

2. **Binary Search Loop**: We enter a while loop, and the search continues as long as `left` is less than or equal to `right`. This is because if `left` becomes greater than `right`, it means we have searched the entire range without finding the target, and we can exit the loop.

3. **Calculate the Middle Index**: In each iteration of the loop, we calculate the middle index `mid` using the formula `(left + right) / 2`. This gives us the index of the middle element in the current search range.

4. **Check Middle Element**: We compare the element at index `mid` in the `nums` array with the target value.

    - If `nums[mid]` is equal to the target, it means we have found the target element, and we return `mid` as the index where the target is located.

    - If `nums[mid]` is less than the target, it means the target must be in the right half of the current search range. So, we update `left` to `mid + 1` to search the right half in the next iteration.

    - If `nums[mid]` is greater than the target, it means the target must be in the left half of the current search range. So, we update `right` to `mid - 1` to search the left half in the next iteration.

5. **Repeat or Exit**: Steps 3 to 4 are repeated in each iteration of the loop, effectively narrowing down the search range by half each time.

6. **Exit Loop**: If the loop exits without finding the target (i.e., `left` becomes greater than `right`), we return -1 to indicate that the target is not present in the array.

The key insight in binary search is that it eliminates half of the remaining elements in each iteration, making it highly efficient, with a logarithmic runtime complexity of O(log n). This is a significant improvement over linear search, especially for large arrays.