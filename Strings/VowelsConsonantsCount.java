public class VowelsConsonantsCount {

    public int[] count(String s) { int v = 0, c = 0;
        String vow = "aeiouAEIOU";
        for (char ch : s.toCharArray()) { if (Character.isLetter(ch)) { if (vow.indexOf(ch) != -1) v++;
                else c++;
            } } return new int[]{v, c};
    };
}
