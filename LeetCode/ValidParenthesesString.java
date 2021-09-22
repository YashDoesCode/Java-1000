
public class ValidParenthesesString {

    public boolean checkValidString(String s) { int minO = 0, maxO = 0;
        for (char c : s.toCharArray()) { if (c == '(') { minO++;
                maxO++;
            } else if (c == ')') { minO--;
                maxO--;
            } else { minO--;
                maxO++;
            } if (maxO < 0) return false;
            minO = Math.max(minO, 0);
        } return minO == 0;
    };
}
