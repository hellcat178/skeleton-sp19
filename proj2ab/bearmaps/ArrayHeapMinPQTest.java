package bearmaps;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class ArrayHeapMinPQTest {




    @Test
    public void sanityContainsTest() {
        ArrayHeapMinPQ<Character> APQ = new ArrayHeapMinPQ<>();
        APQ.add('a',1);
        APQ.add('h',8);
        APQ.add('b',2);


        assertFalse(APQ.contains('k'));
        assertTrue(APQ.contains('a'));

    }

    @Test
    public void sanityGetAndRemoveSmallestTest() {
        ArrayHeapMinPQ<Character> APQ = new ArrayHeapMinPQ<>();
        APQ.add('a',1);
        APQ.add('h',8);
        APQ.add('b',2);
        APQ.add('c',3);
        APQ.add('d',4);
        APQ.add('f',6);
        APQ.add('e',5);
        APQ.add('g',7);
        APQ.add('j',10);
        APQ.add('i',9);

        assertTrue('a' ==  APQ.getSmallest());
        assertTrue('a' ==  APQ.removeSmallest());
        assertTrue('b' ==  APQ.getSmallest());

        APQ.changePriority('b',3.5);
        assertTrue('c' ==  APQ.getSmallest());
        APQ.changePriority('j', 1);
        assertTrue('j' ==  APQ.getSmallest());




    }


}
