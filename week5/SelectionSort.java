package week5;

import edu.princeton.cs.algs4.*;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        In in = new In("D:\\DSA\\Coursera\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();

        int n = a.length;
        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) min = j;
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }


        //run something that takes time
        long end = System.currentTimeMillis();
        System.out.println("Running time: " + (end - start) );
    }
}
