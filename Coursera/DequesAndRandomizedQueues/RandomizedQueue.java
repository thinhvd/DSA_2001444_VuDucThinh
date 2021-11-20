import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] qArr;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        qArr = (Item[]) new Object[1];
        size = 0;
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private int count;
        private final Item[] itArr;

        public RandomQueueIterator() {
            count = 0;
            itArr = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                itArr[i] = qArr[i];
            }
            StdRandom.shuffle(itArr);
        }

        public boolean hasNext() {
            return (count < size);
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return qArr[count++];
        }
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        qArr[size++] = item;
        if (size == qArr.length) resize(2 * qArr.length);
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException();
        int x = StdRandom.uniform(size);
        Item item = qArr[x];
        qArr[x] = qArr[size - 1];
        qArr[size - 1] = null;
        size--;
        if (size > 0 && size == qArr.length / 4) resize(qArr.length / 2);
        return item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = qArr[i];
        }
        qArr = copy;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0) throw new NoSuchElementException();
        return this.qArr[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        rq.enqueue("A");
        rq.enqueue("B");
        rq.enqueue("C");
        rq.dequeue();
        rq.enqueue("D");
        rq.enqueue("E");
        rq.dequeue();
        rq.enqueue("F");
        rq.enqueue("G");
        rq.dequeue();
        Iterator<String> iter1 = rq.iterator();
        Iterator<String> iter2 = rq.iterator();
        while (iter1.hasNext()) {
            System.out.print(iter1.next() + ",");
        }
        System.out.println();
        while (iter2.hasNext()) {
            System.out.print(iter2.next() + ",");
        }
    }
}
