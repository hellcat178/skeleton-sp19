public class LinkedListDeque<T> implements Deque<T> {
    /* Project 1a, implementation of Deque*/
    public class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T i, Node p, Node n) {
                this.item = i;
                this.prev = p;
                this.next = n;

        }

        public void nodeRemove(){
            this.prev = null;
            this.next = null;
        }

    }

    /* The first item (if it exists) is at sentinel.next. */
    private Node sentinel;
    private int size;



    /* Creates an empty Deque. */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    /* Add item to the front of the list.*/
    @Override
    public void addFirst(T item) {
        Node newFirst = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newFirst;
        sentinel.next =  newFirst;
        size++;
    }




    @Override
    public void addLast (T item) {
        Node newLast = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newLast;
        sentinel.prev = newLast;
        size++;
    }


    /* Returns the size of the list. */
    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque(){
        Node p = sentinel.next;
        while (p.next != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }

    @Override
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        Node tobeRemove = sentinel.next; //this is the fist node with item, need to be removed

        //rebuild referrence
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
        //remove the reference of first node, then it will be destroyed by garbage collector.
        tobeRemove.nodeRemove();
        size--;
        return tobeRemove.item;

    }

    /* Should not use loop*/
    @Override
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

    @Override
    public T get(int index){
        if (isEmpty() || index+1 > size){
            return null;
        }

        Node p = sentinel.next;
        int i = 0;
        while (i<index){
            p = p.next;
            i++;
        }
        return p.item;
    }

    public LinkedListDeque(LinkedListDeque other){
        sentinel = new Node(null, sentinel, sentinel);
        size = 0;

        for (int i = 0; i < other.size(); i++){
            addLast((T) other.get(i));
        }
    }

    public LinkedListDeque(Node nextNode, LinkedListDeque list){
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
        return temp.getRecursive(index-1);
    }




}
