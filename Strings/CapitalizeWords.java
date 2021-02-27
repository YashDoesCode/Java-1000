public class CapitalizeWords {

    public String capitalize(String s) { String[] w = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : w) { if (!word.isEmpty()) sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        } return sb.toString().trim();
    };
}
