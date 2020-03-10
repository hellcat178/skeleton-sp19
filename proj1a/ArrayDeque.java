public class ArrayDeque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }


    /** Resize the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 4, items.length);
        items = a;
    }



    public void addFirst(T x) {
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

    public void addLast(T x) {
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
    public T get(int i) {

        return items[nextFirst+i+1];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {

        T x = get(size - 1);
        items[nextLast - 1] = null;
        size--;
        nextLast--;
        return x;
    }

    public T removeFirst() {

        T x = get(0);
        items[nextFirst + 1] = null;
        size--;
        nextFirst++;
        return x;
    }

    public void printDeque() {

        for (T i : items){
            if (i != null)
            System.out.println(i);
        }
    }

    public boolean isEmpty() {

        return size == 0;
    }

    
}
