import org.junit.jupiter.api.Test;

import java.util.Objects;

public class SortedListTest {

    @Test
    void add() {
        SortedList<Integer> list = new SortedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        assert list.size() == 3;
        assert Objects.equals(list.toString(), "[ 1, 2, 3 ]");

        list.clear();

        list.add(3);
        list.add(2);
        list.add(4);

        System.out.println(list);
        assert list.size() == 3;
        assert list.toString().equals("[ 2, 3, 4 ]");
    }

    @Test
    void remove() {
        SortedList<Integer> list = new SortedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        assert list.size() == 3;
        assert Objects.equals(list.toString(), "[ 1, 2, 3 ]");

        list.remove(2);

        System.out.println(list);
        assert list.size() == 2;
        assert Objects.equals(list.toString(), "[ 1, 3 ]");

        list.remove(1);
        list.remove(3);
        assert list.size() == 0;
        list.remove(3);
        assert list.size() == 0;
    }

    @Test
    void get() {
        SortedList<Integer> list = new SortedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        assert list.size() == 3;
        assert Objects.equals(list.toString(), "[ 1, 2, 3 ]");

        Integer value = list.get(2);
        assert value == 3;
    }

    @Test
    void clear() {
        SortedList<Integer> list = new SortedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        assert list.size() == 3;
        assert Objects.equals(list.toString(), "[ 1, 2, 3 ]");

        list.clear();
        assert list.size() == 0;
        assert list.toString().equals("[ ]");
    }

    @Test
    void max() {
        SortedList<Integer> list = new SortedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        assert list.size() == 3;
        assert Objects.equals(list.toString(), "[ 1, 2, 3 ]");
        assert list.max() == 3;
    }

    @Test
    void min() {
        SortedList<Integer> list = new SortedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        assert list.size() == 3;
        assert Objects.equals(list.toString(), "[ 1, 2, 3 ]");
        assert list.min() == 1;
    }
}
