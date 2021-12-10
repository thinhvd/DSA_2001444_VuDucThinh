package week11;

import java.util.HashSet;
import java.util.List;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            set.add(arr.get(i));
        }
        for (int i = 0; i < arr.size(); i++) {
            if (set.contains(arr.get(i) + k)) {
                count++;
            }
        }
        return count;
    }
}
