package week4;

public class LinkedList {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    /**
     *  Bai 1: Print the Elements
     */
    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    /**
     *  Bai 2: Insert a Node at the tail
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if (head == null) {
            head = node;
        } else {
            SinglyLinkedListNode p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
        return head;
    }

    /**
     *  Bai 3: Insert a Node at the head
     */
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        node.next = llist;

        return node;
    }

    /**
     *  Bai 4: Insert a Node at the specific position
     */
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if (position == 0)
        {
            node.next = llist;
            llist = node;
        }
        else{
            SinglyLinkedListNode p = llist;
            for (int i = 0; i < position-1; i++)
            {
                p = p.next;
            }
            node.next = p.next;
            p.next = node;
        }
        return llist;

    }

    /**
     *  Bai 5: Delete a Node
     */
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        SinglyLinkedListNode p = llist;
        if (position > 0)
        {
            for (int i = 0; i < position-1; i++)
            {
                p = p.next;
            }
            p.next = p.next.next;
        }
        else llist = llist.next;
        return llist;
    }

    /**
     * Bai 6: Print in reverse
     */
    public static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
        if (llist != null)
        {
            reversePrint(llist.next);
            System.out.println(llist.data);
        }
    }

    /**
     *  Bai 7: Reverse a Linked list
     */
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        // Write your code here
        SinglyLinkedListNode p1 = null;
        SinglyLinkedListNode p2 = llist;
        SinglyLinkedListNode p3 = null;
        while (p2 != null)
        {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        llist = p1;
        return llist;

    }

    /**
     *  Bai 8: Compare 2 Linked lists
     */
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while (head1 != null && head2 != null){
            if (head1.data != head2.data){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 != null || head2 != null) return false;
        return true;

    }

    /**
     * Bai 9: Merged 2 sorted Linked lists
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        SinglyLinkedListNode merged = null;

        if (head1.data <= head2.data)
        {
            merged = head1;
            merged.next = mergeLists(head1.next,head2);
        }
        else
        {
            merged = head2;
            merged.next = mergeLists(head1,head2.next);
        }
        return merged;

    }

    /**
     * Bai 10: Get Node Value
     */
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode p = llist;
        SinglyLinkedListNode result = llist;
        int count = 0;
        while (p != null)
        {
            p = p.next;
            if (count > positionFromTail)
            {
                result = result.next;
            }
            count++;
        }
        return result.data;

    }
}
