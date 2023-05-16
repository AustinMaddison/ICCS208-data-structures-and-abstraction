class ArrayDeque <T>{

    private final int startCap = 8;
    private final double minUsedCap = 0.25;
    private final int resizeFactor = 2;
    private int front, back, size = 0;

    T[] items;

    ArrayDeque() {
        items = (T[]) new Object[startCap];
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T data) {
        if(isEmpty()) {
            return;
        }
        if(size + 1 > items.length) {
            grow();
        }
        items[front] = data;

    }

    // Adds an item of type T to the back of the deque.
    public void addLast(T data) {
        if(isEmpty()) {
            return;
        }
        if(size + 1 > items.length) {
            grow();
        }
        items[back] = data;


    }

    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return size == 0;
    }


    // Returns the number of items in the deque.
    public int size() {
        return size;
    }

    // Returns a string showing the items in the deque from first to last,
// separated by a space.
    public String toString() {
        String s = "";

        boolean isSameIndex = wrapIndex(front) == wrapIndex(back) && size > 0;
        for (int i = front; front <= back - (isSameIndex? 1:0); i++) {
            s = s + items[i] + ", ";
        }

        return s;
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if(isEmpty())
            return null;
        if((double)(size - 1) / items.length < minUsedCap) {
            shrink();
        }

        items[wrapIndex(front)] = null;
        T removedData = items[wrapIndex(front)];
        front++;
        size--;

        return removedData;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        if(isEmpty())
            return null;

        items[wrapIndex(back)] = null;
        T removedData = items[wrapIndex(back)];
        back--;
        size--;

        return removedData;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if( index < 0 | index > size-1)
            return  null;
        return items[wrapIndex(index+front)];
    }

    private void grow() {
        resize(items.length * resizeFactor);
    }

    private void shrink() {
        resize(items.length / resizeFactor);
    }

    private void resize(int newCap) {
        T[] newItems = (T[]) new Object[newCap];
    }

    private int wrapIndex (int index) {
        return Math.abs(index % 8);
    }

    private void reset_index() {
        front = (items.length / 2) - 1;
        back = front;
    }

    public void printDeque() {
        System.out.println(this.toString());
    }



}