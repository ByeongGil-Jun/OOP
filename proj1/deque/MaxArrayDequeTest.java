package deque;

import edu.princeton.cs.algs4.StdRandom;
import net.sf.saxon.functions.Minimax;
import org.junit.Test;
import java.util.Comparator;
import java.util.Iterator;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class MaxArrayDequeTest {

    @Test
    public void IteratorTest() {
        Comparator<Integer> co = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        MaxArrayDeque<Integer> M = new MaxArrayDeque<Integer>(co);
        M.addLast(2);
        M.addLast(3);
        Iterator<Integer> c= M.iterator();
        while (c.hasNext()) {
            System.out.println(c.next());
        }
    }

    @Test
    public void ComparatorTest() {
        Comparator<String> c = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        MaxArrayDeque<String> a = new MaxArrayDeque<>(c);
        a.addLast("aaaa");
        a.addLast("bab");
        assertEquals("bab", a.get(2));
        assertEquals("aaaa", a.max());

        Comparator<String> d = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        };
        String aa = "aaaa";
        assertEquals("aaaa", a.max(d));
    }

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        MaxArrayDeque<String> lld1 = new MaxArrayDeque<String>(c);

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();
    }

    @Test
    public void Mytest() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        MaxArrayDeque<String> test = new MaxArrayDeque<String>(c);
        assertTrue(test.isEmpty());
        test.addFirst("first");
        assertFalse(test.isEmpty());
        assertEquals(1, test.size());

        test.addLast("f1");
        test.addLast("f2");
        test.addFirst("f0");
        test.printDeque();

        for(int i = 0; i < test.size()+1; i++)
            System.out.println(test.get(i));
    }
    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>(c);
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<>(c);
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        MaxArrayDeque<String>  lld1 = new MaxArrayDeque<String>(c);
        MaxArrayDeque<Double>  lld2 = new MaxArrayDeque<Double>(c);
        MaxArrayDeque<Boolean> lld3 = new MaxArrayDeque<Boolean>(c);

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>(c);

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>(c);
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }
}
