package synthesizer;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        boolean t1 = arb.isEmpty();

        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }

        /*
        for (int i : arb) {
            System.out.println(i);
        }

        Iterator iterator = arb.new bufferIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        */

        boolean t2 = arb.isFull();
        int t3 = (int) arb.dequeue();

        for (int i = 0; i < 9; i++) {
            arb.dequeue();
        }

        boolean t4 = arb.isEmpty();

        assertTrue(t1);
        assertTrue(t2);
        assertEquals(0, t3);
        assertTrue(t4);
    }

    @Test
    public void Test2() {
        ArrayRingBuffer<Integer> arb2 = new ArrayRingBuffer(5);
        boolean t1 = arb2.isEmpty();

        arb2.enqueue(1);
        arb2.enqueue(2);
        arb2.dequeue();
        arb2.dequeue();
        boolean t2 = arb2.isEmpty();

        arb2.enqueue(1);
        arb2.enqueue(2);
        arb2.enqueue(3);
        arb2.enqueue(4);
        arb2.enqueue(5);
        int[] test = new int[5];
        for (int i = 0; i < 5; i++){
            test[i] = arb2.dequeue();
        }

        arb2.enqueue(1);
        arb2.enqueue(2);
        arb2.enqueue(3);
        int[] test2 = new int[3];
        for (int i = 0; i < 3; i++){
            test2[i] = arb2.dequeue();
        }





        assertTrue(t1);
        assertTrue(t2);
        assertArrayEquals(new int[]{1,2,3,4,5}, test);
        assertArrayEquals(new int[]{1,2,3}, test2);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
