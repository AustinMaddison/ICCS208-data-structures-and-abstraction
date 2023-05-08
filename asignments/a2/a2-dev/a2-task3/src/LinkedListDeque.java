import java.util.Deque;

public class LinkedListDeque<T> {
    private static class Node<T>{
        Node<T> next;
        Node<T> prev;
        T data;

        Node(T data) {
            this.next = null;
            this.prev = null;
            this.data = data;
        }
    }
    private final Node<T> sen;
    private int size;

    LinkedListDeque() {
        this.sen = new Node<>(null);
        this.sen.next = this.sen.prev;
        this.sen.prev = this.sen.next;

        this.size = 0;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T data) {
        this.size++;
        Node<T> newNode = new Node<T>(data);
        newNode.next = this.sen.next;
        newNode.prev = null;
        this.sen.next = newNode;

        if(size == 1)
            this.sen.prev = newNode;
        else
            newNode.next.prev = newNode;
    }
    
    // Adds an item of type T to the back of the deque.
    public void addLast(T data) {
        this.size++;
        Node<T> newNode = new Node<T>(data);
        newNode.next = null;
        newNode.prev = this.sen.prev;
        this.sen.prev = newNode;

        if(size == 1)
            this.sen.next = newNode;
        else
            newNode.prev.next = newNode;
    }
    
    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    // Returns the number of items in the deque.
    public int size() {
        return this.size;
    }

    // Returns a string showing the items in the deque from first to last,
// separated by a space.
    public String toString() {
        String s = "";
        for(Node<T> current = sen.next; current != null; current = current.next) {
            s = s + current.data.toString() + ", ";
        }
        return s;
    }
    
    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if(this.size <= 0)
            return null;

        this.size--;
        T item = this.sen.next.data;

        if(size > 0) {
            this.sen.next = this.sen.next.next;
        }
        else {
            this.sen.next = null;
            this.sen.prev = this.sen.next;
        }

        return item;

    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        if(this.size <= 0)
            return null;

        this.size--;
        T item = this.sen.prev.data;

        if(this.size > 0) {
            this.sen.prev = sen.prev.prev;
            this.sen.prev.next = null;
        }
        /* else, no items therefore sen next points to prev */
        else {
            this.sen.prev = null;
            this.sen.next = this.sen.prev;
        }
        return item;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if(index> this.size-1)
            return  null;

        Node<T> current = sen.next;
        for(int currentIndex = 0 ; currentIndex < index; index ++) {
            current = current.next;
        }
        return current.data;
    }
}