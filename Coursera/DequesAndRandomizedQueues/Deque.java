import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private final Item item;
        private Node next;
        private Node prev;

        private Node(Item item) {
            this.item = item;
            next = null;
            prev = null;
        }
    }

    private class ListIterator implements Iterator<Item> {
        private Node cur = head;

        public boolean hasNext() {
            return cur != null;
        }

        public Item next() {
            if (cur == null) throw new NoSuchElementException();
            Item item = cur.item;
            cur = cur.next;
            return item;
        }
    }

    // construct an empty deque
    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldHead = head;
        head = new Node(item);
        head.next = oldHead;
        head.prev = null;

        if (size == 0) {
            tail = head;
        } else {
            oldHead.prev = head;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldTail = tail;
        tail = new Node(item);
        tail.next = null;
        tail.prev = oldTail;

        if (size == 0) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Item item = head.item;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;

        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Item item = tail.item;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> queue = new Deque<>();
        System.out.println(queue.size);
        queue.addFirst("A");
        queue.addFirst("B");
        queue.addLast("C");
        queue.addFirst("D");
        queue.addLast("E");
        queue.addLast("F");
        queue.removeFirst();
        queue.removeLast();
        System.out.println(queue.size);
        Iterator<String> iter = queue.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
