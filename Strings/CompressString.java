public class CompressString {

    public String compress(String s) { StringBuilder sb = new StringBuilder();
        for (int i = 0;
        i < s.length();
        i++) { int cnt = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) { cnt++;
                i++;
            } sb.append(s.charAt(i)).append(cnt);
        } return sb.toString();
    };
}
