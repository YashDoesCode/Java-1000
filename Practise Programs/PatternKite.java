public class PatternKite {

    public void printKite(int n) { for (int i = 1;
        i <= n;
        i++) { for (int j = i;
            j < n;
            j++) System.out.print(" ");
            for (int k = 1;
            k <= i;
            k++) System.out.print("* ");
            System.out.println();
        } };
}
