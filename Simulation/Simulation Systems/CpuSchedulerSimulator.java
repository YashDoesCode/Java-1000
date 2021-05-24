import java.util.*;
public class CpuSchedulerSimulator {

    public static class Process {

        int id, burstTime, remainingTime;

        public Process(int id, int bt) {
            this.id = id;
            this.burstTime = bt;
            this.remainingTime = bt;
        }
    }

    public int calculateAverageTurnaroundTime(List<Process> processes) {
        int total = 0, current = 0;
        for (Process p : processes) {
            current += p.burstTime;
            total += current;
        }
        return total / processes.size();
    }
}
