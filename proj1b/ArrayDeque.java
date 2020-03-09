import java.util.Arrays;

public class ArrayDeque<Item> implements Deque<Item>{
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }


    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 4, items.length);
        items = a;
    }



    @Override
    public void addFirst(Item x) {
        if (nextFirst < 0) {
            resize(items.length * 2);
            nextFirst += 4;
            nextLast += 4;

        }
        items[nextFirst] = x;
        size++;
        nextFirst--;

    }

    /** Inserts X into the back of the list. */

    @Override
    public void addLast(Item x) {
        if (nextLast == items.length) {
            resize(items.length * 2);
            nextFirst += 4;
            nextLast += 4;
        }

        items[nextLast] = x;
        size++;
        nextLast++;
    }



    /** Gets the ith item in the list (0 is the front). */
    @Override
    public Item get(int i) {
        return items[nextFirst+i+1];
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    @Override
    public Item removeLast() {
        Item x = get(size-1);
        items[nextLast-1] = null;
        size--;
        nextLast--;
        return x;
    }

    @Override
    public Item removeFirst() {
        Item x = get(0);
        items[nextFirst+1] = null;
        size--;
        nextFirst++;
        return x;
    }

    @Override
    public void printDeque() {
        for (Item i:items){
            if (i != null)
            System.out.println(i);
        }
    }

}
