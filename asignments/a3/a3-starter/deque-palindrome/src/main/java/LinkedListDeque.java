import javax.swing.*;
public class LinkedListDeque<T> implements Deque<T> {
    private static class Node<T>{
        Node<T> next;
        Node<T> prev;
        T data;

        Node(T data, Node<T> next, Node<T> prev) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }
    private Node<T> sen;
    private int size;


    // Ctor
    LinkedListDeque() {
        initialize();
    }

    // Creates deep copy of linked list deque;
    LinkedListDeque(LinkedListDeque<T> other) {
        initialize();
        if(other.isEmpty())
            return;
        /* Copies all elements from other. */
        Node<T> current = other.sen.next;
        for(int currentIndex = 0; currentIndex < other.size; currentIndex++ ) {
            this.addLast(current.data);
            current = current.next;
        }

    }

    // Initializes member variables, called by ctor.
    private void initialize() {
        sen = new Node<>(null, null, null);
        sen.next = sen;
        sen.prev = sen;
        size = 0;
    }

    // Adds an item of type T to the front of the deque.
    @Override
    public void addFirst(T data) {
        sen.next = new Node<>(data, sen.next, sen);
        sen.next.next.prev = sen.next;
        size++;
    }
    
    // Adds an item of type T to the back of the deque.
    @Override
    public void addLast(T data) {
        sen.prev = new Node<>(data,sen,sen.prev);
        sen.prev.prev.next = sen.prev;
        size++;
    }

    // Returns true if deque is empty, false otherwise.
    @Override
    public boolean isEmpty() {
        return sen.next == sen;
    }

    // Returns the number of items in the deque.
    @Override
    public int size() {
        return size;
    }

    // Returns a string showing the items in the deque from first to last,
    // separated by a space.
    @Override
    public String toString() {
        if(isEmpty())
            return "";

        String s = "";
        for(Node<T> current = sen.next; current != sen; current = current.next) {
            s = s + current.data.toString() + " ";
        }
        return s;
    }
    
    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    @Override
    public T removeFirst() {
        if(isEmpty())
            return null;

        T removedData = sen.next.data;
        sen.next = sen.next.next;
        sen.next.prev = sen;
        size--;

        return removedData;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    @Override
    public T removeLast() {
        if(isEmpty())
            return null;

        T removedData = sen.prev.data;
        sen.prev = sen.prev.prev;
        sen.prev.next = sen;
        size--;

        return removedData;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists, returns null. Must not alter the deque!
    @Override
    public T get(int index) {
        if( index < 0 | index > size-1)
            return  null;

        Node<T> current = sen.next;
        for(int currentIndex = 0; currentIndex < index; currentIndex++ ) {
            current = current.next;
        }

        return current.data;
    }

    public void printDeque() {
        System.out.println(this.toString());
    }

}