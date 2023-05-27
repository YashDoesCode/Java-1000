package Strings;

import java.util.Scanner;
public class ISCPRACTICAL2015 {

    static int vowels,consonants;
    static void count(String word){
        for(int i = 0; i<word.length();i++){
            if(Character.toUpperCase(word.charAt(i))=='A'||Character.toUpperCase(word.charAt(i))=='E'||Character.toUpperCase(word.charAt(i))=='I'||Character.toUpperCase(word.charAt(i))=='O'||Character.toUpperCase(word.charAt(i))=='U')
            vowels++;
            else
            consonants++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence : ");
        String s = sc.nextLine(); String wd = ""; int start = 0;
        if(s.endsWith(".")||s.endsWith("?")){
            String s1 = "";
            System.out.println("Word"+" \t "+"Vowels"+" \t "+"Consonants");
            for(int i = 0 ; i<s.length();i++){
                char c = s.charAt(i);
                if(c==' ' || i==s.length()-1){
                    wd = s.substring(start,i);
                    start = i+1;
                    wd = Character.toUpperCase(wd.charAt(0)) + wd.substring(1);
                    s1+=wd+" ";
                    count(wd);
                    System.out.println(wd+ " \t  "+vowels+" \t\t "+ consonants);
                    vowels =0 ; consonants =0;
                }
            }
            System.out.println(s1);
        }
        else
        System.out.println("Invalid sentence.");
        sc.close();
    }
}
