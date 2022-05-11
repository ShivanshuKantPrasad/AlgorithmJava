package sorting;

import java.util.List;

public class MergeSort {

    public static void inPlaceSort(List<Integer> array, int start, int end){
        if(start == end) return;
        int mid = (start + end) / 2;
        inPlaceSort(array, start, mid); inPlaceSort(array, mid + 1, end);
        inPlaceMerge(array, start, mid, end);
    }

    private static void inPlaceMerge(List<Integer> array, int start, int mid, int end) {
        int i = start; int j = mid + 1;
        while(i <= mid && j <= end){
            if(array.get(i) <= array.get(j)) {
                i++;
            } else {
                int temp = array.get(j);
                int index = j;
                while(index != i) {
                    array.set(index, array.get(index - 1));
                    index--;
                }
                array.set(i, temp);

                i++;
                mid++;
                j++;
            }
        }
    }

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
