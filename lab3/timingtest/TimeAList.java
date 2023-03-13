package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        seq.addLast(1000);
        seq.addLast(2000);
        seq.addLast(4000);
        seq.addLast(8000);
        seq.addLast(16000);
        seq.addLast(32000);
        seq.addLast(64000);
        seq.addLast(128000);
        timeAListConstruction(seq,times);
        printTimingTable(seq, times, seq);
    }

    public static void timeAListConstruction(AList<Integer> seq, AList<Double> times) {
        for (int i = 0; i < seq.size(); i += 1) {
            AList<Integer> test = new AList<>();
            Stopwatch stopWatch = new Stopwatch();
            for (int j = 0; j < seq.get(i); j += 1) {
                test.addLast(0);
            }
            double time = stopWatch.elapsedTime();
            times.addLast(time);
        }
    }
}
