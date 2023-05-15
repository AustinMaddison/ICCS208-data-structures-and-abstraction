public class ArrayDeque <T> {
    private T[] items;
    private int size;
    private int resizeFactor = 2;


    //front and back index
    private int front;
    private int back;


    public ArrayDeque() {
        // capacity starts with 8
        items = (T[]) new Object[8];
        size = 0;
        front = (items.length/2) - 1;
        back = front;
    }

    public int wrapIndex(int index) {
        if(index)
    }

    public void addFirst(T item) {
        if(size + 1 > items.length)
            grow();
        items[wrapIndex(front--)] = item;
    }

    public void addLast(T item) {
        if(size + 1 > items.length)
            grow();
        items[wrapIndex(front++)] = item;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String s = "";
        for(int i = front; i < size; i++) {
            s = s + items[wrapIndex(i)].toString() + ", ";
        }
        return s;
    }

    public T removeFirst() {
        T itemToRemove = items[0];
    }

    public T removeLast() {
        T itemToRemove = items[size - 1];
        items[size - 1] = null; // important: see below
        size--;

        return itemToRemove;
    }

    public T get(int i) {
        return items[i];
    }

    public void grow() {
        resize(items.length * resizeFactor);
    }

    public void shrink() {
        resize(items.length / resizeFactor);
    }

    public void resize(int newCap) {
        T[] newItems = (T[]) new Object[newCap];
        copyItems(newItems);
        items = newItems;

        /* Reset indexing */
        front = newCap / (resizeFactor * 2) - 1;
        back = newCap - (newCap / (resizeFactor * 2)) - 1;
    }

    public void copyItems(T[] newItems) {
        int offset = (newItems.length / (resizeFactor * 2));
        for(int i = front; i < size; i++) {
            newItems[i + offset] = items[wrapIndex(i)];
        }
    }




}



