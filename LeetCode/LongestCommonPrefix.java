
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) { if (strs == null || strs.length == 0) return "";
        String pref = strs[0];
        for (int i = 1;
        i < strs.length;
        i++) { while (strs[i].indexOf(pref) != 0) pref = pref.substring(0, pref.length() - 1);
        } return pref;
    };
}
