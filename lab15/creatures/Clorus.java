package creatures;

import huglife.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class Clorus extends Creature {

    /** red color. */
    private int r;
    /** green color. */
    private int g;
    /** blue color. */
    private int b;


    /**
     * Creates a Clorus with the name clorus and energy e.
     */
    public Clorus(double e) {
        super("clorus");
        r = 34;
        g = 0;
        b = 231;
        energy = e;
    }

    /** creates a clorus with energy equal to 1. */
    public Clorus() {
        this(1);
    }


    /** Clorus should lose 0.03 units of energy when moving. If you want to
     *  to avoid the magic number warning, you'll need to make a
     *  private static final variable. This is not required for this lab.
     */
    @Override
    public void move() {
        energy -= 0.03;
    }

    /** attack a plip and rob it's energy*/
    @Override
    public void attack(Creature c) {
        energy += c.energy();
    }

    @Override
    public Creature replicate() {
        energy *= 0.5;
        return new Clorus(energy);
    }


    /** Clorus should lose 0.01 units of energy when staying. If you want to
     *  to avoid the magic number warning, you'll need to make a
     *  private static final variable. This is not required for this lab.
     */
    @Override
    public void stay() {
        energy -= 0.01;
    }

    /** Clorus will take the flowing steps based on NEIGHBORS
     * 1. If there are no empty squares, the Clorus will STAY (even if there are Plips nearby they could attack).
     * 2. Otherwise, if any Plips are seen, the Clorus will ATTACK one of them randomly.
     * 3. Otherwise, if the Clorus has energy greater than or equal to one, it will REPLICATE to a random empty square.
     * 4. Otherwise, the Clorus will MOVE to a random empty square.
     */
    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        List<Creature> preies = getNeighborsCreatureOfType(neighbors, "plip");
        List<Direction> preyDirection = getNeighborsCreatureDirectionOfType(neighbors, "plip");

        if (empties.size() == 0) {
            return new Action(Action.ActionType.STAY);
        }

        if (preies.size() != 0) {
            Direction attackDir = HugLifeUtils.randomEntry(preyDirection);
            return new Action(Action.ActionType.ATTACK, attackDir);
        }

        if (energy >= 1) {
            Direction repDir = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.REPLICATE, repDir);
        }

        Direction moveDir = HugLifeUtils.randomEntry(empties);
        return new Action(Action.ActionType.MOVE, moveDir);

    }


    /** Should return a color with red = 34, green = 0, blue = 231.
     */
    @Override
    public Color color() {
        return color(r, g, b);
    }
}
