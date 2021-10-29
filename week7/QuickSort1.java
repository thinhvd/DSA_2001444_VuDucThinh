package week7;

import java.util.ArrayList;
import java.util.List;

public class QuickSort1 {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(0)) result.add(arr.get(i));
        }
        result.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(0)) result.add(arr.get(i));
        }

        return result;
    }
}
