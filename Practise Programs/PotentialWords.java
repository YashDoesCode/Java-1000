
package PractisePrograms;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PotentialWords {

    public PotentialWords() {
    }

    static int potentialOfWord(String word) {
        int p = 0;

        for(int i = 0; i < word.length(); ++i) {
            p += word.charAt(i);
        }

        return p;
    }

    public static void main(String[] args) {
        boolean p = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence : ");
        String s = sc.nextLine().toUpperCase();
        StringTokenizer st = new StringTokenizer(s, " .?");
        String[] words = new String[st.countTokens()];
        int count = st.countTokens();

        for(int i = 0; i < count; ++i) {
            String wd = st.nextToken();
            words[i] = wd;
        }

        int[] ASCII = new int[words.length];
        if (s.charAt(s.length() - 1) != '?' && s.charAt(s.length() - 1) != '!' && s.charAt(s.length() - 1) != '.' && s.charAt(s.length() - 1) != ' ') {
            System.out.println("Invalid sentence. ");
        } else {
            int j;
            for(int i = 0; i < words.length; ++i) {
                for(j = i + 1; j < words.length; ++j) {
                    if (potentialOfWord(words[j]) < potentialOfWord(words[i])) {
                        String temp = words[i];
                        words[i] = words[j];
                        words[j] = temp;
                    }
                }
            }

            String[] var14 = words;
            j = words.length;

            for(int var15 = 0; var15 < j; ++var15) {
                String e = var14[var15];
                System.out.print(e + " ");
            }
        }

    }
}
