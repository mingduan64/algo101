public class Solution2 {
    public int trap(int[] height){
        int res =0;
        int left_max = 0;
        int right_max = 0;
        int left = 0;
        int right = height.length -1;
        while(left< right){
            left_max = Math.max(left_max, height[left]);
            right_max = Math.max(right_max, height[right]);
            if(left_max < right_max){
                res += left_max-height[left];
                left++;
            }
            else{
                res += right_max - height[right];
                right--;
            }
        }
        return res;
    }
}
