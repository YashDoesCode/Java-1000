import java.util.*;
public class TowerOfHanoiRecursion {

    public void hanoi(int n, char from, char to, char aux, List<String> moves) { if (n == 1) { moves.add("Move disk 1 from " + from + " to " + to);
            return;
        } hanoi(n - 1, from, aux, to, moves);
        moves.add("Move disk " + n + " from " + from + " to " + to);
        hanoi(n - 1, aux, to, from, moves);
    };
}
