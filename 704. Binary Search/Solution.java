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
