public class CountAndSayStr {

    public String countAndSay(int n) { if (n <= 0) return "";
        String res = "1";
        while (--n > 0) { StringBuilder sb = new StringBuilder();
            char[] c = res.toCharArray();
            for (int i = 0;
            i < c.length;
            i++) { int cnt = 1;
                while (i + 1 < c.length && c[i] == c[i + 1]) { cnt++;
                    i++;
                } sb.append(cnt).append(c[i]);
            } res = sb.toString();
        } return res;
    };
}
