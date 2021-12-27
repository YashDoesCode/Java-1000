import java.util.*;
public class BullsAndCowsMap {

    public String getHint(String secret, String guess) { int bulls = 0, cows = 0;
        int[] cnt = new int[10];
        for (int i = 0;
        i < secret.length();
        i++) { int s = secret.charAt(i) - '0', g = guess.charAt(i) - '0';
            if (s == g) bulls++;
            else { if (cnt[s] < 0) cows++;
                if (cnt[g] > 0) cows++;
                cnt[s]++;
                cnt[g]--;
            } } return bulls + "A" + cows + "B";
    };
}
