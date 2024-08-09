import org.junit.jupiter.api.Test;

public class SortedHeapTest {


    @Test
    void size() {
        var heap = new SortedHeap<Integer>();
        heap.add(1);
        heap.add(2);
        heap.add(3);

        assert heap.size() == 3;
    }

    @Test
    void min() {
        var heap = new SortedHeap<Integer>();
        heap.add(3);
        heap.add(2);
        heap.add(4);

        var min = heap.min();
        assert min == 2;
    }

    @Test
    void add() {
        var heap = new SortedHeap<Integer>();
        heap.add(3);
        heap.add(2);
        heap.add(4);

        assert heap.size() == 3;
        assert heap.toString().equals("[2, 3, 4]");
    }

    @Test
    void remove() {
        var heap = new SortedHeap<Integer>();
        heap.add(3);
        heap.add(2);
        heap.add(4);

        assert heap.size() == 3;
        var min = heap.min();
        assert min == 2;

        heap.remove(2);
        assert heap.size() == 2;
        assert heap.min() == 3;
    }
}
