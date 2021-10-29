package week6;

import edu.princeton.cs.algs4.In;

public class MergeSort {
    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for(int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if(i > mid)                 a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if(aux[j] < aux[i])    a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }

    public static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    //sxxuoi
    //sxnguoc
    //giatribangnhau
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        In in = new In("D:\\DSA\\Coursera\\algs4-data\\1Mints.txt");
        int[] a = in.readAllInts();

        int [] aux = new int[a.length];

        sort(a, aux, 0, a.length - 1);

        long end = System.currentTimeMillis();
        System.out.println("Running time: " + (end - start) );
    }
}
