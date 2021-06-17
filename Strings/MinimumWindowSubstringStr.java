/*
 * Popular Question: Minimum Window Substring
 * Source: LeetCode #76 (Hard / Top Interview Classic)
 *
 * Problem Statement:
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s
 * such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 *
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 *
 * Constraints:
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 */

public class MinimumWindowSubstringStr {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] targetCounts = new int[128];
        for (int i = 0; i < t.length(); i++) {
            targetCounts[t.charAt(i)]++;
        }

        int[] windowCounts = new int[128];
        int requiredChars = 0;
        for (int count : targetCounts) {
            if (count > 0) {
                requiredChars++;
            }
        }

        int left = 0;
        int right = 0;
        int formedChars = 0;

        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowCounts[rightChar]++;

            if (targetCounts[rightChar] > 0 && windowCounts[rightChar] == targetCounts[rightChar]) {
                formedChars++;
            }

            while (left <= right && formedChars == requiredChars) {
                char leftChar = s.charAt(left);

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                windowCounts[leftChar]--;
                if (targetCounts[leftChar] > 0 && windowCounts[leftChar] < targetCounts[leftChar]) {
                    formedChars--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstringStr solver = new MinimumWindowSubstringStr();

        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";

        String s2 = "a";
        String t2 = "a";

        String s3 = "a";
        String t3 = "aa";

        String res1 = solver.minWindow(s1, t1);
        String res2 = solver.minWindow(s2, t2);
        String res3 = solver.minWindow(s3, t3);

        System.out.println("Test Case 1 Window: \"" + res1 + "\"");
        System.out.println("Test Case 2 Window: \"" + res2 + "\"");
        System.out.println("Test Case 3 Window: \"" + res3 + "\"");
    }
}
