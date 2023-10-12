public class CompareVersionStr {

    public int compareVersion(String v1, String v2) { String[] s1 = v1.split("\\."), s2 = v2.split("\\.");
        int len = Math.max(s1.length, s2.length);
        for (int i = 0;
        i < len;
        i++) { int n1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            int n2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;
            if (n1 != n2) return Integer.compare(n1, n2);
        } return 0;
    };
}
