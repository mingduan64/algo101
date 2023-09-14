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

Approach 2: Hashset
Since triplets must sum up to the target value, we can try the hash table approach from the Two Sum solution. This approach won't work, however, if the sum is not necessarily equal to the target, like in 3Sum Smaller and 3Sum Closest.

We move our pivot element nums[i] and analyze elements to its right. We find all pairs whose sum is equal -nums[i] using the Two Sum: One-pass Hash Table approach, so that the sum of the pivot element (nums[i]) and the pair (-nums[i]) is equal to zero.

To do that, we process each element nums[j] to the right of the pivot, and check whether a complement -nums[i] - nums[j] is already in the hashset. If it is, we found a triplet. Then, we add nums[j] to the hashset, so it can be used as a complement from that point on.

Like in the approach above, we will also sort the array so we can skip repeated values. We provide a different way to avoid duplicates in the "No-Sort" approach below.

Algorithm

The main function is the same as in the Two Pointers approach above. Here, we use twoSum (instead of twoSumII), modified to produce triplets and skip repeating values.

For the main function:

Sort the input array nums.
Iterate through the array:
If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
If the current value is the same as the one before, skip it.
Otherwise, call twoSum for the current position i.
For twoSum function:

For each index j > i in A:
Compute complement value as -nums[i] - nums[j].
If complement exists in hashset seen:
We found a triplet - add it to the result res.
Increment j while the next value is the same as before to avoid duplicates in the result.
Add nums[j] to hashset seen
Return the result res.


Time Complexity: O(n2)\mathcal{O}(n^2)O(n
2
). twoSum is O(n)\mathcal{O}(n)O(n), and we call it nnn times.

Sorting the array takes O(nlog⁡n)\mathcal{O}(n\log{n})O(nlogn), so overall complexity is O(nlog⁡n+n2)\mathcal{O}(n\log{n} + n^2)O(nlogn+n
2
). This is asymptotically equivalent to O(n2)\mathcal{O}(n^2)O(n
2
).

Space Complexity: O(n)\mathcal{O}(n)O(n) for the hashset.