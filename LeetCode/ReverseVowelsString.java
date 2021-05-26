
public class ReverseVowelsString {

    public String reverseVowels(String s) { char[] a = s.toCharArray();
        int l = 0, r = a.length - 1;
        String v = "aeiouAEIOU";
        while (l < r) { while (l < r && v.indexOf(a[l]) == -1) l++;
            while (l < r && v.indexOf(a[r]) == -1) r--;
            char t = a[l];
            a[l++] = a[r];
            a[r--] = t;
        } return new String(a);
    };
}
