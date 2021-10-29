package week7;

import java.util.List;

public class FindTheMedian {
    public static void exch(List<Integer> a, int i, int j) {
        int tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    public static int partition(List<Integer> a, int lo, int hi) {
        int i = lo;
        int pivot = a.get(hi);
        for (int j = lo; j < hi; j++) {
            if (a.get(j) <= pivot) {
                exch(a, i, j);
                i++;
            }
        }
        exch(a, i, hi);
        return i;
    }

    public static int findMedian(List<Integer> arr, int lo, int hi) {
        // Write your code here
        int n = arr.size();
        if (lo == hi)
            return arr.get(lo);
        if (lo < hi) {
            int q = partition(arr, lo, hi);
            if (q == n / 2)
                return arr.get(q);
            else if (q > n / 2)
                return findMedian(arr, lo, q - 1);
            else
                return findMedian(arr, q + 1, hi);
        }

        return 0;
    }
}