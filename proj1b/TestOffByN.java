import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    static OffByN offByN = new OffByN(5);
    @Test
    public void testEqualChars(){
        assertTrue(offByN.equalChars('a','f'));
        assertTrue(offByN.equalChars('f','a'));
        assertTrue(offByN.equalChars('b','g'));
        assertFalse(offByN.equalChars('x','x'));
        assertFalse(offByN.equalChars('1','3'));
        assertFalse(offByN.equalChars('#','#'));
    }
}
