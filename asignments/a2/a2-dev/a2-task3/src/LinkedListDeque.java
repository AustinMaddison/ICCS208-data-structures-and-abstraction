import javax.swing.*;
import java.util.Deque;

public class LinkedListDeque<T> {
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
    private final Node<T> sen;
    private int size;

    LinkedListDeque() {
        sen = new Node<>(null, null, null);
        sen.next = sen;
        sen.prev = sen;

        size = 0;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T data) {
        sen.next = new Node<>(data, sen.next, sen);
        sen.next.next.prev = sen.next;
        this.size++;
    }
    
    // Adds an item of type T to the back of the deque.
    public void addLast(T data) {
        sen.prev = new Node<>(data,sen,sen.prev);
        sen.prev.prev.next = sen.prev;
        this.size++;
    }
    
    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return this.sen.next == sen;
    }


    // Returns the number of items in the deque.
    public int size() {
        return this.size;
    }

    // Returns a string showing the items in the deque from first to last,
// separated by a space.
    public String toString() {
        String s = "";
        for(Node<T> current = sen.next; current != sen; current = current.next) {
            s = s + current.data.toString() + ", ";
        }
        return s;
    }
    
    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
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
    public T get(int index) {
        if( index < 0 | index > size-1)
            return  null;

        Node<T> current = sen.next;
        for(int currentIndex = 0 ; currentIndex < index; index ++) {
            current = current.next;
        }

        return current.data;
    }

    public void printDeque() {
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        LinkedListDeque<String> a = new LinkedListDeque<>();

        a.addFirst("a");
        a.addFirst("b");
        a.addFirst("c");
        a.addFirst("d");
        a.addFirst("e");
        a.printDeque();
        System.out.println("size: " + a.size);
        System.out.println((a.removeLast()));
        System.out.println((a.removeFirst()));
        System.out.println("size: " + a.size);
        a.printDeque();
        a.addLast("last");
        a.addLast("last");
        a.addLast("last");
        a.printDeque();
        System.out.println("size: " + a.size);
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.printDeque();
        System.out.println(a.isEmpty());
        System.out.println("size: " + a.size);


        a.addLast("last");
        a.addFirst("first");
        a.printDeque();
        System.out.println(a.isEmpty());





    }
}