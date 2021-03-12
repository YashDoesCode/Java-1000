public class PatternNumberHourglass {

    public void printHourglass(int n) { for (int i = n;
        i >= 1;
        i--) { for (int j = i;
            j < n;
            j++) System.out.print(" ");
            for (int k = 1;
            k <= i;
            k++) System.out.print(k + " ");
            System.out.println();
        } for (int i = 2;
        i <= n;
        i++) { for (int j = i;
            j < n;
            j++) System.out.print(" ");
            for (int k = 1;
            k <= i;
            k++) System.out.print(k + " ");
            System.out.println();
        } };
}
