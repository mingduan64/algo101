Approach 1: Two Pointers
We will follow the same two pointers pattern as in Two Sum II. It requires the array to be sorted, so we'll do that first. As our BCR is O(n2)\mathcal{O}(n^2)O(n
2
), sorting the array would not change the overall time complexity.

To make sure the result contains unique triplets, we need to skip duplicate values. It is easy to do because repeating values are next to each other in a sorted array.

If you are wondering how to solve this problem without sorting the array, go over the "No-Sort" approach below. There are cases when that approach is preferable, and your interviewer may probe your knowledge there.

After sorting the array, we move our pivot element nums[i] and analyze elements to its right. We find all pairs whose sum is equal -nums[i] using the two pointers pattern, so that the sum of the pivot element (nums[i]) and the pair (-nums[i]) is equal to zero.

As a quick refresher, the pointers are initially set to the first and the last element respectively. We compare the sum of these two elements to the target. If it is smaller, we increment the lower pointer lo. Otherwise, we decrement the higher pointer hi. Thus, the sum always moves toward the target, and we "prune" pairs that would move it further away. Again, this works only if the array is sorted. Head to the Two Sum II solution for the detailed explanation.

Current

Algorithm

The implementation is straightforward - we just need to modify twoSumII to produce triplets and skip repeating values.

For the main function:

Sort the input array nums.
Iterate through the array:
If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
If the current value is the same as the one before, skip it.
Otherwise, call twoSumII for the current position i.
For twoSumII function:

Set the low pointer lo to i + 1, and high pointer hi to the last index.
While low pointer is smaller than high:
If sum of nums[i] + nums[lo] + nums[hi] is less than zero, increment lo.
If sum is greater than zero, decrement hi.
Otherwise, we found a triplet:
Add it to the result res.
Decrement hi and increment lo.
Increment lo while the next value is the same as before to avoid duplicates in the result.
Return the result res.

    class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
    if (i == 0 || nums[i - 1] != nums[i]) {
    twoSumII(nums, i, res);
    }
    return res;
    }
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
    int lo = i + 1, hi = nums.length - 1;
    while (lo < hi) {
    int sum = nums[i] + nums[lo] + nums[hi];
    if (sum < 0) {
    ++lo;
    } else if (sum > 0) {
    --hi;
    } else {
    res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
    while (lo < hi && nums[lo] == nums[lo - 1])
    ++lo;
    }
    }
    }
    }

Complexity Analysis

Time Complexity: O(n2)\mathcal{O}(n^2)O(n
2
). twoSumII is O(n)\mathcal{O}(n)O(n), and we call it nnn times.

Sorting the array takes O(nlog⁡n)\mathcal{O}(n\log{n})O(nlogn), so overall complexity is O(nlog⁡n+n2)\mathcal{O}(n\log{n} + n^2)O(nlogn+n
2
). This is asymptotically equivalent to O(n2)\mathcal{O}(n^2)O(n
2
).

Space Complexity: from O(log⁡n)\mathcal{O}(\log{n})O(logn) to O(n)\mathcal{O}(n)O(n), depending on the implementation of the sorting algorithm. For the purpose of complexity analysis, we ignore the memory required for the output.