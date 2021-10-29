package week7;

public class PriorityQueue {
    private int[] pq;
    private int K;

    public void insert(int x) {
        pq[K++] = x;
    }

    public int deleteMin() {
        int min = 0;
        for (int i = 1; i < K; i++) {
            if (pq[i] < pq[min] ) min = i;
        }

        int tmp = pq[min];
        pq[min] = pq[K-1];
        pq[K-1] = tmp;

        return pq[--K];
    }
}
