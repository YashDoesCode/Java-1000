import java.util.*;
public class SimplifyPathStr {

    public String simplify(String path) { Stack<String> st = new Stack<>();
        for (String dir : path.split("/")) { if (dir.equals("..")) { if (!st.isEmpty()) st.pop();
            } else if (!dir.isEmpty() && !dir.equals(".")) st.push(dir);
        } return "/" + String.join("/", st);
    };
}
