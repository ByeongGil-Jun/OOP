package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        SLList temp = new SLList();
        AList NS = new AList();
        AList times = new AList();
        AList opCounts = new AList();
        int [] a= new int []{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};

        for(int i : a) {
            NS.addLast(i);
            times.addLast(AddGetlast(temp, i));
            opCounts.addLast(10000);
            temp = new SLList();
        }

        printTimingTable(NS, times, opCounts);
    }

    public static double AddGetlast(SLList temp, int N){
        for(int i = 0; i < N; i++){
            temp.addLast(1);
        }
        Stopwatch sw = new Stopwatch();
        for(int i = 0; i < 10000; i++){
            temp.getLast();
        }
        return sw.elapsedTime();
    }
}
