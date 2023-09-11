import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the complement of each number and its index
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                // Return the indices of the two numbers
                return new int[]{numMap.get(complement), i};
            }

            // Add the current number and its index to the map
            numMap.put(num, i);
        }

        // If no solution is found, return an empty array or handle it as needed
        return new int[0];
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println(" Input nums: ");
        int[] nums = new int[]{sc.nextInt()};

        System.out.println(" Input target: ");
        int target = sc.nextInt();

        System.out.println(twoSum(nums, target));

    }
}
