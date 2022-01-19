public class PigLatinConvert {

    public String toPigLatin(String w) { String v = "AEIOUaeiou";
        for (int i = 0;
        i < w.length();
        i++) { if (v.indexOf(w.charAt(i)) != -1) return w.substring(i) + w.substring(0, i) + "ay";
        } return w + "ay";
    };
}
