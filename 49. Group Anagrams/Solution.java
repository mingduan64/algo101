import java.util.*;

public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagroups = new HashMap<>();

        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedW = new String(chars);
            anagroups.computeIfAbsent(sortedW, k-> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagroups.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input the word list: ");

        String[] words = new String[]{sc.nextLine()};
        List<List<String>> anagramGroups = groupAnagrams(words);

        System.out.println("Anagram Group: " + anagramGroups);
    }
}
