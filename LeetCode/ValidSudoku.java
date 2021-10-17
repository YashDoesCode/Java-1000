
import java.util.*;
public class ValidSudoku {

    public boolean isValidSudoku(char[][] b) { Set<String> s = new HashSet<>();
        for (int i = 0;
        i < 9;
        i++) { for (int j = 0;
            j < 9;
            j++) { char c = b[i][j];
                if (c != '.') { if (!s.add(c + " in row " + i) || !s.add(c + " in col " + j) || !s.add(c + " in block " + i / 3 + "-" + j / 3)) return false;
                } } } return true;
    };
}
