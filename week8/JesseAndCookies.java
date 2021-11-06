package week8;

import java.util.List;
import java.util.PriorityQueue;

public class JesseAndCookies {
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int n = A.size();
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(A.get(i));
        }
        while (pq.peek() < k && pq.size() > 1) {
            int m1 = pq.remove();
            int m2 = pq.remove();
            int sweetness = m1 + 2*m2;
            pq.add(sweetness);
            count++;
        }
        if (pq.peek() >= k) return count;
        return -1;
    }
}
