package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            } else if (operationNumber == 2) {
                //getLast
                if(L.size() == 0) {
                    int last = L.get(0);
                }
                int last = L.getLast();
            } else {
                //removeLast
                if(L.size() == 0)
                    continue;
                L.removeLast();
            }
        }
    }
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing a = new AListNoResizing();
        BuggyAList b = new BuggyAList();
        a.addLast(4); b.addLast(4);
        a.addLast(5); b.addLast(5);
        a.addLast(6); b.addLast(6);

        assertEquals(a.size(), b.size());

        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());

    }
    @Test
    public void RandomizedCompares() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> M = new BuggyAList<Integer>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                M.addLast(randVal);
                assertEquals(L.getLast(), M.getLast());
            } else if (operationNumber == 1) {
                // size
                assertEquals(L.size(), M.size());
            } else if (operationNumber == 2) {
                //getLast
                if (L.size() == 0 || M.size() == 0) {
                    assertEquals(L.get(0), M.get(0));
                    continue;
                }
                assertEquals(L.getLast(), M.getLast());
            } else {
                //removeLast
                if (L.size() == 0 || M.size() == 0) {
                    continue;
                }
                assertEquals(L.removeLast(), M.removeLast());
            }
        }
    }
}

