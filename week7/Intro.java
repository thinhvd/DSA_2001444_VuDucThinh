package week7;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Intro {
    public static int introTutorial(int V, List<Integer> arr) {
        int l = 0;
        int r = arr.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) == V) return mid;
            if (arr.get(mid) > V) {
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return -1;
    }
}
