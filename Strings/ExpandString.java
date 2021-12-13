public class ExpandString {

    public String expand(String s) { StringBuilder sb = new StringBuilder();
        for (int i = 0;
        i < s.length();
        i++) { char c = s.charAt(i);
            i++;
            int num = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) { num = num * 10 + (s.charAt(i) - '0');
                i++;
            } i--;
            for (int j = 0;
            j < num;
            j++) sb.append(c);
        } return sb.toString();
    };
}
