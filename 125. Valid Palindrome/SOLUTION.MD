Approach 1: Compare with Reverse
Intuition

A palindrome is a word, phrase, or sequence that reads the same backwards as forwards. e.g. madam

A palindrome, and its reverse, are identical to each other.

Algorithm

We'll reverse the given string and compare it with the original. If those are equivalent, it's a palindrome.

Since only alphanumeric characters are considered, we'll filter out all other types of characters before we apply our algorithm.

Additionally, because we're treating letters as case-insensitive, we'll convert the remaining letters to lower case. The digits will be left the same.

    class Solution {
    public boolean isPalindrome(String s) {
    StringBuilder builder = new StringBuilder();

    for (char ch : s.toCharArray()) {
      if (Character.isLetterOrDigit(ch)) {
        builder.append(Character.toLowerCase(ch));
      }
    }

    String filteredString = builder.toString();
    String reversedString = builder.reverse().toString();

    return filteredString.equals(reversedString);
}

/** An alternate solution using Java 8 Streams */

    public boolean isPalindromeUsingStreams(String s) {
    StringBuilder builder = new StringBuilder();

    s.chars()
        .filter(c -> Character.isLetterOrDigit(c))
        .mapToObj(c -> Character.toLowerCase((char) c))
        .forEach(builder::append);

    return builder.toString().equals(builder.reverse().toString());
}
}

Complexity Analysis

Time complexity : O(n)O(n)O(n), in length nnn of the string.

We need to iterate thrice through the string:

When we filter out non-alphanumeric characters, and convert the remaining characters to lower-case.
When we reverse the string.
When we compare the original and the reversed strings.
Each iteration runs linear in time (since each character operation completes in constant time). Thus, the effective run-time complexity is linear.

Space complexity : O(n)O(n)O(n), in length nnn of the string. We need O(n)O(n)O(n) additional space to stored the filtered string and the reversed string.


