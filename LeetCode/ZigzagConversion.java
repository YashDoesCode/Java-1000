
public class ZigzagConversion {

    public String convert(String s, int numRows) { if (numRows == 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0;
        i < numRows;
        i++) sbs[i] = new StringBuilder();
        int idx = 0, dir = 1;
        for (char c : s.toCharArray()) { sbs[idx].append(c);
            if (idx == 0) dir = 1;
            else if (idx == numRows - 1) dir = -1;
            idx += dir;
        } StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) res.append(sb);
        return res.toString();
    };
}
