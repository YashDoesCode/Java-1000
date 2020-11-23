public class BankDeadlockDetector {

    public boolean isSafeState(int[] available, int[][] max, int[][] allocation) {
        int numProcesses = max.length;
        int numResources = available.length;
        int[][] need = new int[numProcesses][numResources];
        for (int i = 0; i < numProcesses; i++) {
            for (int j = 0; j < numResources; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
        boolean[] finish = new boolean[numProcesses];
        int[] work = available.clone();
        int count = 0;
        while (count < numProcesses) {
            boolean found = false;
            for (int p = 0; p < numProcesses; p++) {
                if (!finish[p]) {
                    int j;
                    for (j = 0; j < numResources; j++) {
                        if (need[p][j] > work[j]) break;
                    }
                    if (j == numResources) {
                        for (int k = 0; k < numResources; k++) {
                            work[k] += allocation[p][k];
                        }
                        finish[p] = true;
                        found = true;
                        count++;
                    }
                }
            }
            if (!found) return false;
        }
        return true;
    }
}
