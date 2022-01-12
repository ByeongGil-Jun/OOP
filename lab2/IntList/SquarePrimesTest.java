package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesinclude2() {
        IntList lst = IntList.of(2, 4, 7, 8, 53, 73, 88);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 4 -> 49 -> 8 -> 2809 -> 5329 -> 88", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesFalse() {
        IntList lst = IntList.of(4, 4, 16, 8, 6, 12, 24);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 4 -> 16 -> 8 -> 6 -> 12 -> 24", lst.toString());
        assertFalse(changed);
    }
}
