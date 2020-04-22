package bearmaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T> {

    ArrayList<Node> items;
    int n; //number of items on PQ
    public ArrayHeapMinPQ(){
        items = new ArrayList<>();
        items.add(null);
        n = 0;
    }


    private class Node {
        private T item;
        private double priority;
        private Node(T item, double priority) {
            this.item = item;
            this.priority = priority;
        }


    }
    @Override
    public void add(T item, double priority) {
        if (item == null) {
            throw new IllegalArgumentException("calls add() with a null item");
        }
        if (contains(item)) {
            throw new IllegalArgumentException("item is already in the PQ");
        }

        n = n + 1;
        items.add(new Node(item, priority));
        swim(n);

    }
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k / 2;
        }
    }

    //compare priority
    private boolean greater(int i, int j){
        return items.get(i).priority > items.get(j).priority;
    }
    //change element
    private void exch(int i, int j) {
        Node swap = items.get(i);
        items.set(i, items.get(j));
        items.set(j, swap);
    }




    @Override
    public boolean contains(T item) {



        for (int i = 1; i < items.size(); i++) {
            if (items.get(i).item.equals(item)){
                return true;
            }
        }
        return false;


    }
    //seems slow

    @Override
    public T getSmallest() {
        if (n == 0) {
            throw new NoSuchElementException();
        }
        return items.get(1).item;
    }

    @Override
    public T removeSmallest() {
        if (n == 0) {
            throw new NoSuchElementException();
        }
        Node min = items.get(1);
        exch(1,n--);
        sink(1);
        items.set(n+1, null);
        return min.item;
    }
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }

    }


    @Override
    public int size() {
        return n;
    }

    @Override
    public void changePriority(T item, double priority) {

        if (!contains(item)) {
            throw new NoSuchElementException();
        }

        for (int i = 1; i < items.size(); i++) {
            if (items.get(i).item.equals(item)) {
                double originalPriority = items.get(i).priority;
                items.set(i, new Node(item, priority));
                if (originalPriority < priority){
                    sink(i);
                } else {
                    swim(i);
                }
                break;
            }

        }



    }

    public static void main(String[] args) {
        ArrayHeapMinPQ<Character> APQ = new ArrayHeapMinPQ<>();
        APQ.add('a',1);
        System.out.println(APQ.contains('a'));

    }

}
