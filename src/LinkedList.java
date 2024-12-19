import java.util.Iterator;
class LinkedList<L> implements Iterable<L> {
    private class Node {
        L data;
        Node next;

        Node(L data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(L data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(L data) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.data.equals(data)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                if (current == tail) {
                    tail = previous;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<L> iterator() {
        return new Iterator<L>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public L next() {
                L data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}