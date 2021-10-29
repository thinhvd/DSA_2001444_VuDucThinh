package week6;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

//sxxuoi
//sxnguoc
//giatribangnhau
public class InsertionSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        In in = new In("D:\\DSA\\Coursera\\algs4-data\\1Mints.txt");
        int[] a = in.readAllInts();
        int n = a.length;

        //int n = 16000;
        //double[] a = new double[n];
        //for (int i = 0; i < n; i++)
            //a[i] = StdRandom.uniform();

        for(int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j-1]) {
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
                else break;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Running time: " + (end - start) );
    }
}
