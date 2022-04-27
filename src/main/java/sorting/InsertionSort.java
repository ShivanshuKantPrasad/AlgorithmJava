package sorting;

import java.util.ArrayList;

public class InsertionSort {
    public static void sort(ArrayList<Integer> array) {
        for(int i = 1; i < array.size(); i++){
            for(int j = 0; j < i; j++){
                if(array.get(i) < array.get(j)){
                    int temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                }
            }

        }

    }
}
