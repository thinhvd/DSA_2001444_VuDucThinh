package week9;

import java.util.ArrayList;
import java.util.List;

public class newClosetNumber {
    public static void merge(List<Integer> a, int lo, int mid, int hi) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        List<Integer> left = new ArrayList<>(n1);
        List<Integer> right = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) {
            left.add(0);
        }
        for (int i = 0; i < n2; i++) {
            right.add(0);
        }

        for (int i = 0; i < n1; ++i)
            left.set(i, a.get(lo + i));
        for (int j = 0; j < n2; ++j)
            right.set(j, a.get(mid + 1 + j));

        // Merge mang con
        int i = 0; // index left
        int j = 0; // index right

        int k = lo;
        while (i < n1 && j < n2) {
            if (left.get(i) <= right.get(j)) {
                a.set(k,left.get(i));
                i++;
            } else {
                a.set(k,right.get(j));
                j++;
            }
            k++;
        }

        // khi left van con phan tu
        while (i < n1) {
            a.set(k,left.get(i));
            i++;
            k++;
        }

        // khi right van con phan tu
        while (j < n2) {
            a.set(k,right.get(j));
            j++;
            k++;
        }
    }

    public static void sort(List<Integer> a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> diff = new ArrayList<Integer>();
        sort(arr, 0, n - 1);
        for (int i = 0; i < n - 1; i++) {
            diff.add(arr.get(i + 1) - arr.get(i));
        }
        int min = diff.get(0);
        for (int i = 0; i < n - 1; i++) {
            if (min >= diff.get(i)) min = diff.get(i);
        }
        for (int i = 0; i < n - 1; i++) {
            if (diff.get(i) == min) {
                result.add(arr.get(i));
                result.add(arr.get(i + 1));
            }
        }
        return result;
    }
}
