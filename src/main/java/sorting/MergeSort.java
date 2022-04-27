package sorting;

import java.util.List;

public class MergeSort {
    public static void sort(List<Integer> array) {
        if(array.size() == 1) return;
        int mid = array.size() / 2;
        List<Integer> start = array.subList(0, mid);
        List<Integer> end = array.subList(mid, array.size());
        sort(start); sort(end);
        merge(array, start, end);
    }

    private static void merge(List<Integer> array, List<Integer> start, List<Integer> end) {
        int m = 0; int n = 0;
        for(int i = 0; i < array.size(); i++){
            if(m < start.size() && n < end.size()){
                if(start.get(m) < end.get(n)) {
                    array.set(i, start.get(m));
                    m++;
                } else {
                    array.set(i, end.get(n));
                    n++;
                }
            } else if(m >= start.size()){
                array.set(i, end.get(n));
                n++;
            } else {
                array.set(i, start.get(m));
                m++;
            }

        }

    }
}
