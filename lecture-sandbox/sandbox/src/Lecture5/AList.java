package Lecture5;

import java.lang.reflect.Type;
import java.util.ArrayList;


/* Exercise I: Actions in the Front */


/* Exercise II: Array List with Generic Types¶ */
public class AList <T>  {

    private T[] items;
    private int size;

    public AList() {
        this.items = (T[]) new Object[1];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int i) {
        return items[i];
    }

    public T getFirst() {
        return items[0];
    }

    public T getLast() {
        return items[size];
    }

    public void grow(int newCap) {
        T[] newItems = (T[]) new Object[newCap];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
    }

    public void addFirst(T item) {
        if(size == items.length)
            grow(size * 2);
        for(int i = size-1; i >= 0; i--) {
            items[i+1] = items[i];
        }
        items[0] = item;
        size++;
    }
    public void addLast(T item) {
        if(size == items.length)
            grow(size * 2);
        items[size++] = item;
    }

    public T removeLast() {
        T itemToRemove = items[size - 1];
        items[size - 1] = null; // important: see below
        size--;

        return itemToRemove;
    }


    public String toString() {
        String s = "";
        for(int i = 0; i < size; i++) {
            s = s + items[i].toString() + ", ";
        }

        return s;
    }

    public static void main(String[] args) {
        AList<Integer> a = new AList<Integer>();
        a.addLast(1);
        a.addLast(2);
        a.addFirst(2);
        System.out.println(a.toString());
    }
}
