/*
 * Popular Question: Custom Sort String
 * Source: LeetCode #791 (Medium)
 *
 * Problem Statement:
 * You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
 * Permute the characters of s so that they match the order that order was sorted.
 * More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
 * Return any permutation of s that satisfies this property.
 *
 * Example 1:
 * Input: order = "cba", s = "abcd"
 * Output: "cbad"
 * Explanation: "c", "b", "a" appear in order, so the order of "c", "b", "a" should be "c", "b", "a".
 * Since "d" does not appear in order, it can be at any position in the returned string. "cbad" is one valid answer.
 *
 * Example 2:
 * Input: order = "cbafg", s = "abcd"
 * Output: "cbad"
 *
 * Constraints:
 * 1 <= order.length <= 26
 * 1 <= s.length <= 200
 * order and s consist of lowercase English letters.
 * All characters of order are unique.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomSortStringStr {

    public String customSortString(String order, String s) {
        if (order == null || s == null) {
            return "";
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            int idx = ch - 'a';
            while (count[idx] > 0) {
                sb.append(ch);
                count[idx]--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                sb.append((char) ('a' + i));
                count[i]--;
            }
        }

        return sb.toString();
    }

    public String customSortStringComparator(String order, String s) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        Character[] charArray = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }

        Arrays.sort(charArray, (a, b) -> {
            int posA = orderMap.getOrDefault(a, 26);
            int posB = orderMap.getOrDefault(b, 26);
            return Integer.compare(posA, posB);
        });

        StringBuilder sb = new StringBuilder();
        for (char ch : charArray) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        CustomSortStringStr sorter = new CustomSortStringStr();

        String order1 = "cba";
        String s1 = "abcd";

        String order2 = "bcafg";
        String s2 = "abcdba";

        String res1 = sorter.customSortString(order1, s1);
        String res1Comp = sorter.customSortStringComparator(order1, s1);
        String res2 = sorter.customSortString(order2, s2);

        System.out.println("Result 1 (Frequency Array): " + res1);
        System.out.println("Result 1 (Custom Comparator): " + res1Comp);
        System.out.println("Result 2 (Frequency Array): " + res2);
    }
}
