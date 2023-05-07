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
    
    private class Sentinel {
        private Node<T> start;
        private Node<T> end;
        
        Sentinel(){
            start = null;
            end = null;
        }
    }
    private Sentinel sen;
    private int size;

    LinkedListDeque() {
        this.sen = new Sentinel();
        this.size = 0;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T data) {
        this.size++;
        Node<T> newNode = new Node<T>(data);
        newNode.next = this.sen.start;
        newNode.prev = null;
        this.sen.start = newNode;

        if(size == 1)
            this.sen.end = newNode;
        else
            newNode.next.prev = newNode;
    }
    
    // Adds an item of type T to the back of the deque.
    public void addLast(T data) {
        this.size++;
        Node<T> newNode = new Node<T>(data);
        newNode.next = null;
        newNode.prev = this.sen.end;
        this.sen.end = newNode;

        if(size == 1)
            this.sen.start = newNode;
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
        for(Node<T> current = sen.start; current != null; current = current.next) {
            s = s + current.data.toString() + ", ";
        }
        return s;
    }
    
    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        size--;
        T item = this.sen.start.data;
        this.sen.start = this.sen.start.next;
        return item;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        size--;
        T item = this.sen.end.data;
        this.sen.end.prev.next = null;
        return item;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if(index> this.size-1)
            return  null;

        Node<T> current = sen.start;
        for(int currentIndex = 0 ; currentIndex < index; index ++) {
            current = current.next;
        }
        return current.data;
    }

    public static void main(String[] args) {

    }

}