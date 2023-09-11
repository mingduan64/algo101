class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Compute prefix products
        int product = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = product;
            product *= nums[i];
        }

        // Compute suffix products and update result
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }
}