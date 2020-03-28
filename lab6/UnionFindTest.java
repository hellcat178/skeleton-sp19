import org.junit.Test;
import static org.junit.Assert.*;
public class UnionFindTest {
    @Test
    public void UFtest() {
        UnionFind uf = new UnionFind(10);
        uf.union(0,1);
        uf.union(1,2);
        uf.union(2,3);
        uf.union(3,4);
        assertEquals(5, uf.sizeOf(0));
        assertEquals(5, uf.sizeOf(1));
        assertEquals(5, uf.sizeOf(2));
        assertEquals(5, uf.sizeOf(3));
        assertTrue(uf.connected(0,3));

        //Test
    }



    public static void main(String[] args) {
        System.exit(jh61b.junit.textui.runClasses(UnionFindTest.class));
    }
}
