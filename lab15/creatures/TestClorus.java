package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

/** Tests the clorus class
 *
 */


public class TestClorus {

    @Test
    public void testBasics() {
        Clorus c = new Clorus(2);
        assertEquals(2, c.energy(), 0.01);
        assertEquals(new Color(34, 0,231), c.color());
        c.move();
        assertEquals(1.97, c.energy(), 0.01);
        c.move();
        assertEquals(1.94, c.energy(), 0.01);
        c.stay();
        assertEquals(1.93, c.energy(), 0.01);
        c.stay();
        assertEquals(1.92, c.energy(), 0.01);

        Plip p = new Plip(0.08);
        c.attack(p);
        assertEquals(2.00, c.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Clorus c1 = new Clorus(2);
        Clorus c2 = (Clorus) c1.replicate();
        Clorus c3 = (Clorus) c2.replicate();


        assertNotSame(c1,c2);
        assertNotSame(c2,c3);

        double[] ppenergy = {c1.energy(), c2.energy(), c3.energy()};
        double[] ans = {1.0, 0.5, 0.5};

        assertArrayEquals(ans, ppenergy, 0);

    }

    @Test
    public void testChoose() {
        Clorus c = new Clorus(2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        //Test STAY
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        //Test ATTACK
        int attackLeft = 0;
        int attackRight = 0;
        for (int i = 0; i < 1000; i++){
            HashMap<Direction, Occupant> surrounded2 = new HashMap<Direction, Occupant>();
            surrounded2.put(Direction.TOP, new Impassible());
            surrounded2.put(Direction.BOTTOM, new Empty());
            surrounded2.put(Direction.LEFT, new Plip());
            surrounded2.put(Direction.RIGHT, new Plip());

            Action actual2 = c.chooseAction(surrounded2);
            if (actual2.equals(new Action(Action.ActionType.ATTACK, Direction.RIGHT))) {
                attackRight++;
            }

            if (actual2.equals(new Action(Action.ActionType.ATTACK, Direction.LEFT))) {
                attackLeft++;
            }

        }

        assertEquals(0.5, attackLeft/1000.0,0.1);
        assertEquals(0.5, attackRight/1000.0,0.1);
    }

    public static void main(String[] args) {
        System.exit(jh61b.junit.textui.runClasses(TestClorus.class));
    }
}
