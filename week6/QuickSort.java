package week6;

import edu.princeton.cs.algs4.In;

public class QuickSort {
    public static void exch(int[] a ,int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static int partition(int[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        while (true)
        {
            while (a[++i] < a[lo])
                if (i == hi) break;
            while (a[lo] < a[--j])
                if (j == lo) break;

            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void sort(int[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    //sxxuoi
    //sxnguoc
    //giatribangnhau
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        In in = new In("D:\\DSA\\Coursera\\algs4-data\\giatribangnhau.txt");
        int[] a = in.readAllInts();

        sort(a,0, a.length - 1);

        long end = System.currentTimeMillis();
        System.out.println("Running time: " + (end - start) );
    }
}
