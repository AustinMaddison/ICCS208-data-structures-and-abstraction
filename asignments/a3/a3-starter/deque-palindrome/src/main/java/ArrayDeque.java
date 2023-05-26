public class ArrayDeque <T> implements Deque<T>{
    private final int startCap = 8;
    private final double minUsedCap = 0.25;
    private final int resizeFactor = 2;
    private int front, back, size;

    T[] items;

    ArrayDeque() {
        initialize();
    }

    ArrayDeque(ArrayDeque<T> other) {
        initialize(other.items.length, other.size, other.front, other.back);
        if(other.isEmpty()) {
            return;
        }
        /* Copies all elements from other. */
        for(int index = 0 ; index < other.items.length; index++) {
            items[index] = other.items[index];
        }
    }

    // Initializes member variables, called by ctor.
    private void initialize(int initCap, int initSize, int initFront, int initBack) {
        items = (T[]) new Object[initCap];
        size = initSize;
        front = initFront;
        back = initBack;
    }

    private void initialize(int initCap) {
        initialize(initCap, 0, 0, 0);
    }

    private void initialize() {
       initialize(startCap, 0, 0, 0);
    }


    // Adds an item of type T to the front of the deque.
    @Override
    public void addFirst(T data) {
        if(isEmpty()) {
            reset_index();
            items[front] = data;
            size++;
            return;
        }
        if(shouldGrow()) {
            grow();
        }
        front--;
        size++;
        items[wrapIndex(front)] = data;
    }

    // Adds an item of type T to the back of the deque.
    @Override
    public void addLast(T data) {
        if(isEmpty()) {
            reset_index();
            items[back] = data;
            size++;
            return;
        }
        if(shouldGrow()) {
            grow();
        }
        back++;
        size++;
        items[wrapIndex(back)] = data;
    }

    // Returns true if deque is empty, false otherwise.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the number of items in the deque.
    @Override
    public int size() {
        return size;
    }

    public int cap() { return items.length; }

    // Returns a string showing the items in the deque from first to last,
    // separated by a space.
    @Override
    public String toString() {
        String s = "";
        for (int i = front; i - front < size; i++) {
            s = s + items[wrapIndex(i)] + " ";
        }

        return s;
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    @Override
    public T removeFirst() {
        if(isEmpty())
            return null;
        if(shouldShrink()) {
            shrink();
        }
        T removedData = items[wrapIndex(front)];
        items[wrapIndex(front)] = null;
        front++;
        size--;

        return removedData;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    @Override
    public T removeLast() {
        if(isEmpty())
            return null;
        if(shouldShrink()) {
            shrink();
        }
        T removedData = items[wrapIndex(back)];
        items[wrapIndex(back)] = null;
        back--;
        size--;

        return removedData;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists, returns null. Must not alter the deque!
    @Override
    public T get(int index) {
        if( index < 0 | index > size-1)
            return  null;
        return items[wrapIndex(index+front)];
    }

    private boolean shouldShrink() {
        return (double)(size - 1) / items.length < minUsedCap && items.length > startCap;
    }
    private boolean shouldGrow() {
        return size + 1 > items.length;
    }

    private void grow() {
        resize(items.length * resizeFactor);
    }

    private void shrink() {
        resize(items.length / resizeFactor);
    }

    private void resize(int newCap) {
        T[] newItems = (T[]) new Object[newCap];
        for (int i = front; i - front < size; i++) {
            newItems[wrapIndex(i-front, newCap)] =  items[wrapIndex(i)];
        }

        /* update indexes */
        front = 0;
        if(newCap > items.length) // if grows
            back = items.length - 1;
        else
            back = size -1; // if shrinks

        items = newItems;
    }

    private int wrapIndex (int index) {
       return wrapIndex(index, items.length);
    }

    private int wrapIndex (int index, int cap) {
        if(index >= 0){
            return index % cap;
        }
        else {
            return index + cap;
        }
    }

    private void reset_index() {
        front = 0;
        back = front;
    }

    public void printDeque() {
        System.out.println(this.toString());
    }

}