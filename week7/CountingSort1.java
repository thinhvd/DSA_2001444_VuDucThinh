package week7;

import java.util.ArrayList;
import java.util.List;

public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            result.add(0);
        }
        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i);
            int k = result.get(x);
            result.set(x, k+1);
        }
        return result;
    }
}
