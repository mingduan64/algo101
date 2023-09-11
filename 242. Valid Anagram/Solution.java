import java.util.Scanner;
import java.util.Arrays;
public class Solution {
    public static boolean isAnagram(String s, String t){
        // Remove spaces and convert to lowercase (if case-insensitive comparison is desired)
        s = s.replaceAll("\\s", "").toLowerCase();
        t = t.replaceAll("\\s", "").toLowerCase();
//        s.replaceAll("\\s", ""):
//        This line uses the replaceAll method on the string s and uses a regular expression (\\s) to find all whitespace characters
//        (including spaces, tabs, and line breaks) and replaces them with an empty string. This effectively removes all spaces from the string s.
        // Check if the lengths of the strings are equal
        if (s.length() != t.length()) {
            return false;
        }

        // Convert strings to character arrays and sort them
//        s.toCharArray(), it converts the string s into an array of characters.

//      charArray1: This is a new character array variable that is declared to store the result of converting the string s into an array of characters.
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
//        The Arrays.sort method in Java works by using an efficient sorting algorithm to rearrange the elements of an array in ascending order.
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted character arrays
        return Arrays.equals(charArray1, charArray2);

    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first String: ");
        String s = sc.nextLine();

        System.out.println("Enter second String: ");
        String t  = sc.nextLine();

        boolean isAna = isAnagram(s,t);

        if (isAna){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
