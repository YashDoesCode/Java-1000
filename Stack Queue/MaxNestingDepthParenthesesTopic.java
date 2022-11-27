public class MaxNestingDepthParenthesesTopic {

    public int maxDepth(String s) { int cur = 0, maxV = 0;
        for (char c : s.toCharArray()) { if (c == '(') { cur++;
                maxV = Math.max(maxV, cur);
            } else if (c == ')') cur--;
        } return maxV;
    };
}
