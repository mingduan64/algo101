class Solution {
    public int trap(int[] height) {
        int res = 0;
        if (height.length == 0) {
            return 0;
        }
        int[] leftMax = new int[height.length];

        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];

        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];

        for (int j = rightMax.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        for (int x = 0; x < height.length; x++) {
            res += Math.min(leftMax[x], rightMax[x]) - height[x];
        }
        return res;
    }
}
