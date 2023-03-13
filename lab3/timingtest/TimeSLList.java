package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        AList<Integer> seq = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> ops = new AList<>();

        seq.addLast(1000);
        seq.addLast(2000);
        seq.addLast(4000);
        seq.addLast(8000);
        seq.addLast(16000);
        seq.addLast(32000);
        seq.addLast(64000);
        seq.addLast(128000);

        for (int i = 0; i < seq.size(); i += 1) {
            ops.addLast(10000);
        }

        timeGetLast(seq, times, ops);
        printTimingTable(seq, times, ops);
    }

    public static void timeGetLast(AList<Integer> seq, AList<Double> times, AList<Integer> opCounts){
        for (int i = 0; i < seq.size(); i += 1) {
            SLList<Integer> slList = new SLList<>();
            for (int j = 0; j < seq.get(i); j += 1) {
                slList.addFirst(j);
            }
            Stopwatch sw = new Stopwatch();
            for (int k = 0; k < opCounts.size(); k += 1) {
                slList.getLast();
            }
            double time = sw.elapsedTime();
            times.addLast(time);
        }
    }
}
