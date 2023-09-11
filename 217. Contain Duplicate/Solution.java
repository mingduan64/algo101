import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
//        new int[n]: This is the right-hand side of the assignment. It creates a new integer array and specifies its size.
        int[] nums = new int[n];

        System.out.println("Enter the elements: ");
//        In your loop, int i=0; initializes the loop variable i to 0. This sets the starting point for your loop.
//        In your loop, i++ increments the value of i by 1 after each iteration. This ensures that i takes on a new value in each iteration.
        for(int i=0; i <n; i++){
            nums[i] = sc.nextInt();
        }
        boolean hasDup = containsDuplicate(nums);
        if(hasDup){
            System.out.println("The array contains dup ele");
        }else {
            System.out.println("The array does not contain dup ele");
        }

        sc.close();
    }
    public static boolean containsDuplicate(int[] nums){
//        In Java, a Set is an interface that represents a collection of elements,
                Set<Integer> uniqueElements = new HashSet<>();
//        This is the constructor call for the HashSet class.
//        It creates a new instance of a HashSet.
//        The angle brackets < > indicate that the HashSet will store elements of type Integer, making it a Set of integers.
        for (int num : nums){
//            int num: This part declares a loop variable named num with the data type int.
//            The loop variable is used to represent each element in the collection as you iterate through it.

//            nums: This is the name of the array or iterable collection that you want to iterate through.
//            In the context of your example, nums is assumed to be an array of integers.
//            The loop variable num takes on the value of each element in the nums array one by one.?
            if(uniqueElements.contains(num)){
                return true;
            }
            uniqueElements.add(num);
        }
        return false;
    }
}
