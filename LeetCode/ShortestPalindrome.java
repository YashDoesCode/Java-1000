
public class ShortestPalindrome {

    public String shortestPalindrome(String s) { String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    } private int[] getTable(String s) { int[] table = new int[s.length()];
        int index = 0;
        for (int i = 1;
        i < s.length();
        i++) { if (s.charAt(i) == s.charAt(index)) { table[i] = ++index;
            } else { if (index != 0) { index = table[index - 1];
                    i--;
                } else table[i] = 0;
            } } return table;
    };
}
