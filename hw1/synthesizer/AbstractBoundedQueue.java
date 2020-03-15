package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {

    protected int fillCount;
    protected int capaticy;


    public int capacity() {
        return capaticy;
    }


    public int fillCount() {
        return fillCount;
    }


    public abstract void enqueue(T x);


    public abstract T dequeue();


    public abstract T peek();
}
