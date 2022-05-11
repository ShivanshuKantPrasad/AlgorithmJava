package sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {

    ArrayList<Integer> array;

    @BeforeEach
    void setUp() {
        array = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            array.add(rand.nextInt());
        }
    }

    @RepeatedTest(5)
    @DisplayName("Insertion Test")
    void testInsertSort(){
        InsertionSort.sort(array);
        isSorted(array);
    }

    @RepeatedTest(5)
    @DisplayName("Merge Sort")
    void testMergeSort(){
        MergeSort.sort(array);
        isSorted(array);
    }

    @RepeatedTest(5)
    @DisplayName("In Place Merge Sort")
    void testInPlaceMergeSort(){
        MergeSort.inPlaceSort(array, 0, array.size() - 1);
        isSorted(array);
    }

    static void isSorted(ArrayList<Integer> array) {
        ArrayList<Integer> copy = new ArrayList<>(array);
        copy.sort(Comparator.naturalOrder());
        assertEquals(copy, array, "Array should be sorted");
    }

}
