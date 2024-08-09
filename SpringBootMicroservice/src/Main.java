import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    public static List<Integer> createInsertionList(int numValues) {
        var insertionList = new ArrayList<Integer>();
        for (int i = 0; i < numValues; i++) {
            var intToInsert = ThreadLocalRandom.current().nextInt();
            insertionList.add(intToInsert);
        }
        return insertionList;
    }

    public static void compareSortedVsUnsortedInsert(int numValues) {
        var unsortedList = new ArrayList<Integer>();
        var sortedList = new SortedList<Integer>();
        var insertionList = createInsertionList(numValues);

        var startTime = System.nanoTime();
        for (int i = 0; i < numValues; i++) {
            unsortedList.add(insertionList.get(i));
        }
        var endTime = System.nanoTime();
        var elapsed = endTime - startTime;
        var elapsedSeconds = (double)elapsed / 1E9;
        System.out.printf("Execution time for (unsorted) was: %.8fs\n", elapsedSeconds);

        startTime = System.nanoTime();
        for (int i = 0; i < numValues; i++) {
            sortedList.add(insertionList.get(i));
        }
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        elapsedSeconds = (double)elapsed / 1E9;

        System.out.printf("Execution time for (sorted) was: %.8fs\n", elapsedSeconds);
    }

    public static void compareSortedVsUnsortedMinMax(int numValues) {
        var unsortedList = new ArrayList<Integer>();
        var sortedList = new SortedList<Integer>();
        var insertionList = createInsertionList(numValues);

        var startTime = System.nanoTime();
        for (int i = 0; i < numValues; i++) {
            unsortedList.add(insertionList.get(i));
        }
        var currentMax = Integer.MIN_VALUE;
        for (Integer integer : unsortedList) {
            if (integer > currentMax) {
                currentMax = integer;
            }
        }
        var endTime = System.nanoTime();
        var elapsed = endTime - startTime;
        var elapsedSeconds = (double)elapsed / 1E9;
        System.out.printf("Execution time for (unsorted) was: %.8fs with max elem: %d\n", elapsedSeconds, currentMax);

        startTime = System.nanoTime();
        for (int i = 0; i < numValues; i++) {
            sortedList.add(insertionList.get(i));
        }
        currentMax = sortedList.max();
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        elapsedSeconds = (double)elapsed / 1E9;

        System.out.printf("Execution time for (sorted) was: %.8fs with max elem: %d\n", elapsedSeconds, currentMax);
    }

    public static void compareSortedListVsHeapInsert(int numValues) {
        var sortedHeap = new SortedHeap<Integer>();
        var sortedList = new SortedList<Integer>();
        var insertionList = createInsertionList(numValues);

        var startTime = System.nanoTime();
        for (int i = 0; i < numValues; i++) {
            sortedHeap.add(insertionList.get(i));
        }
        var endTime = System.nanoTime();
        var elapsed = endTime - startTime;
        var elapsedSeconds = (double)elapsed / 1E9;
        var min = sortedHeap.min();
        System.out.printf("Execution time for (heap) was: %.8fs with min elem: %d\n", elapsedSeconds, min);

        startTime = System.nanoTime();
        for (int i = 0; i < numValues; i++) {
            sortedList.add(insertionList.get(i));
        }
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        elapsedSeconds = (double)elapsed / 1E9;
        min = sortedList.min();
        System.out.printf("Execution time for (list) was: %.8fs with max elem: %d\n", elapsedSeconds, min);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

//        compareSortedVsUnsortedInsert(100_000);
//        compareSortedVsUnsortedMinMax(100_000);
        compareSortedListVsHeapInsert(100_000);
    }
}