package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {

    protected int fillCount;
    private int capacity;
    AbstractBoundedQueue(int c){
        this.capacity = c;
    }
    public int capacity() {
        return capacity;
    }
    public int fillCount() {
        return fillCount;
    }

}
