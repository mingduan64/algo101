public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int t = nums[i];
            while (j >= 0 && t < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            if (j >= 0 && nums[j] == t) {
                return true;
            }
            nums[j + 1] = t;
        }
        return false;
    }
}
