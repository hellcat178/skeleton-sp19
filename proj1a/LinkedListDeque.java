public class LinkedListDeque<T> {

    /** Project 1a, implementation of Deque*/
    private class Node {

        private T item;
        private Node prev;
        private Node next;

        private Node(T i, Node p, Node n) {
                this.item = i;
                this.prev = p;
                this.next = n;

        }

        private void nodeRemove() {

            this.prev = null;
            this.next = null;
        }

    }

    /** The first item (if it exists) is at sentinel.next. */
    private Node sentinel;
    private int size;



    /** Creates an empty Deque. */
    public LinkedListDeque() {

        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    /** Add item to the front of the list.*/
    public void addFirst(T item) {
        Node newFirst = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newFirst;
        sentinel.next =  newFirst;
        size++;
    }

    /* Add item to the end of the list.
    This method is not good enough. Should not use any loop.
     */
    /*
    public void addLastLoopMethod (T item) {

        Node p = sentinel;
        while (p.next != sentinel){
            p = p.next;
        }
        p.next = new Node(item, p, sentinel);
        sentinel.prev = p.next;

        size++;
    }
    */

    /** Add item to the end of the list.*/
    public void addLast (T item) {
        Node newLast = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newLast;
        sentinel.prev = newLast;
        size++;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    /** Returns the size of the list. */
    public int size() {

        return size;
    }

    public void printDeque(){

        Node p = sentinel.next;
        while (p.next != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }

    public T removeFirst(){

        if (isEmpty()){
            return null;
        }
        Node tobeRemove = sentinel.next; //this is the fist node with item, need to be removed
        //rebuild reference

        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
        //remove the reference of first node, then it will be destroyed by garbage collector.
        tobeRemove.nodeRemove();
        size--;
        return tobeRemove.item;

    }

    /* Should not use loop*/
    public T removeLast(){

        if (isEmpty()){
            return null;
        }
        //find the last node, it will be removed
        Node tobeRemove = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;


        size--;
        return tobeRemove.item;

    }

    public T get(int index){

        if (isEmpty() || index + 1 > size){
            return null;
        }

        Node p = sentinel.next;
        int i = 0;
        while (i < index){
            p = p.next;
            i++;
        }
        return p.item;
    }

    /*
    public LinkedListDeque(LinkedListDeque other){
        sentinel = new Node(null, sentinel, sentinel);
        size = 0;

        for (int i = 0; i < other.size(); i++){
            addLast((T) other.get(i));
        }
    }
    */

    private LinkedListDeque(Node nextNode, LinkedListDeque list){

        sentinel = nextNode;
        size = list.size() - 1;
    }


    public T getRecursive(int index){

        if (isEmpty() || index+1 > size){
            return null;
        }

        if(index == 0){
            return sentinel.next.item;
        }
        LinkedListDeque<T> temp = new LinkedListDeque(this.sentinel.next,this);
        return temp.getRecursive(index - 1);
    }

}
