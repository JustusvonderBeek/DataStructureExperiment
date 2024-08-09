import java.util.ArrayList;
import java.util.List;

public class SortedList<T extends Comparable<T>> {

    private final List<T> elements;

    public SortedList() {
        // Handles the underlying data structure and expansion of the list
        elements = new ArrayList<>(1);
    }

    public int size() {
        return elements.size();
    }

    public T max() {
        if (this.size() == 0) {
            return null;
        }
        return elements.get(this.size()-1);
    }

    public T min() {
        if (this.size() == 0) {
            return null;
        }
        return elements.get(0);
    }

    public void add(T elem) {
//        System.out.println("Before: " + this.toString());
        if (elements.isEmpty()) {
            elements.add(elem);
            return;
        }
        int sizeBeforeInsertion = this.size();
        for (int i = 0; i < sizeBeforeInsertion; i++) {
            if (elem.compareTo(elements.get(i)) < 0) {
                elements.add(i, elem);
                break;
            }
            // continue on equal or greater and insert before the next bigger one
            // but insert if this is the largest element
            if (i + 1 == size()) {
                elements.add(elem);
            }
        }
    }

    public void remove(T elem) {
        elements.remove(elem);
    }

    public void clear() {
        elements.clear();
    }

    public T get(int index) {
        return elements.get(index);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(size());
        string.append("[ ");
        for (T elem : elements) {
            string.append(elem);
            string.append(", ");
        }
        // Remove the last ',' but only if one or more elements are contained
        if (string.length() > 2) {
            string.deleteCharAt(string.length()-2);
        }
        string.append("]");
        return string.toString();
    }
}
