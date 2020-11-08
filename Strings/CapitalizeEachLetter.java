package Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class CapitalizeEachLetter {

    static String capitalizeWord(String s){
        String ans = "";
        String []t = s.split("\\s");
        for(String w : t){
            String first = w.substring(0,1);
            String second = w.substring(1 );
            ans +=first.toUpperCase()+second+" ";
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String s = sc.nextLine();

        ArrayList<String> words = new ArrayList<>();
        int start = 0;

        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                if (start < i) {
                    String word = s.substring(start, i);

                    String capitalizedWord = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                    words.add(capitalizedWord);
                }
                start = i + 1;
            }
        }


        System.out.println("Capitalized Sentence:");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println("Capitalized sentence : " + capitalizeWord(s));
        System.out.println();
        sc.close();
    }
}
