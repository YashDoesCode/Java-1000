import java.util.*;

public class TowerOfHanoiSolver {

    public List<String> solve(int n, char from, char to, char aux) {
        List<String> moves = new ArrayList<>();
        solveRecursive(n, from, to, aux, moves);
        return moves;
    }

    private void solveRecursive(int n, char from, char to, char aux, List<String> moves) {
        if (n == 1) {
            moves.add("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }
        solveRecursive(n - 1, from, aux, to, moves);
        moves.add("Move disk " + n + " from rod " + from + " to rod " + to);
        solveRecursive(n - 1, aux, to, from, moves);
    }
}
