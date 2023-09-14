import java.util.Scanner;

class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // No solution found
        return new int[]{};
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input int array: ");
        int[] nums = new int[]{sc.nextInt()};

        System.out.println("Please input target: ");
        int k = sc.nextInt();

        System.out.println(twoSum(nums,k));

    }
}