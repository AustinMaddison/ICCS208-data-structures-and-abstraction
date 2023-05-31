package quiz2;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayList {
    private int[] items;
    private String encryptCode;
    private int size;

    public MyArrayList() {
        items = new int[2];
        size = 0;
        encryptCode = null;
    }

    private void grow(int newCapacity) {
        int[] newItems = new int[newCapacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void add(int value) {
        if (size == items.length) {
            grow(items.length * 2);
        }
        items[size] = value;
        size += 1;
    }

    public void setEncryptCode(String val) {
        this.encryptCode = val;
    }

    public int size() {
        return size;
    }

    public int removeFirst() throws NoSuchElementException {
        if(size == 0) {
            throw new NoSuchElementException();
        }

        int removedItem = items[0];
        for(int idx = 1; idx < items.length -1; idx++) {
            items[idx] = items[idx + 1];
        }
        size--;
        return removedItem;
    }

    public boolean equals(Object o) {
        MyArrayList other = (MyArrayList) o;

        if( o == null) {
            return false;
        }
        if(o.getClass() != this.getClass()) {
            return false;
        }
        if (!Objects.equals(other.encryptCode, this.encryptCode)) {
            return false;
        }
        if (((MyArrayList) o).size != this.size) {
            return false;
        }
        for(int idx = 0; idx < this.size; idx++) {
            if(other.items[idx] != this.items[idx]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        MyArrayList a = new MyArrayList();
        MyArrayList b = new MyArrayList();

        a.add(3);
        a.add(4);
        a.removeFirst();

        b.add(3);
        b.add(4);
        b.removeFirst();

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(b.equals(a));
    }
}
