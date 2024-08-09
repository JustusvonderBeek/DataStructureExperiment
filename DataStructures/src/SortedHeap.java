import java.util.PriorityQueue;

public class SortedHeap<T extends Comparable<T>> {

    private PriorityQueue<T> queue;

    public SortedHeap() {
        queue = new PriorityQueue<>(1);
    }

    public int size() {
        return queue.size();
    }

    public T min() {
        return queue.peek();
    }

    public void add(T elem) {
        queue.add(elem);
    }

    public void remove(T elem) {
        queue.remove(elem);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
