public class ArrayDeque <T> {
    private final int startCap = 4;
    private T[] items;
    private int size;
    private final int resizeFactor = 2;
    private final double usedCapMin = 0.25;

    //front and back index
    private int front;
    private int back;

    public ArrayDeque() {
        // capacity starts with 8
        items = (T[]) new Object[startCap];
        size = 0;
    }

    public void addFirst(T item) {
        if(isEmpty()) {
            resetIndex();
            items[front] = item;
            size++;
            return;
        }
        if(++size > items.length) {
            grow();
        }
        front--;
        items[wrapIndex(front)] = item;
    }

    public void addLast(T item) {
        if (isEmpty()) {
            resetIndex();
            items[back] = item;
            size++;
            return;
        }
        if (++size > items.length) {
            grow();
        }
        back++;
        items[wrapIndex(back)] = item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String s = "";
        for(int i = front; i <= back; i++) {
            s = s + items[wrapIndex(i)].toString() + ", ";
        }
        return s;
    }

    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        if(size > startCap && size-1 < usedCapMin*(double)items.length) {
            shrink();
        }
        T itemToRemove = items[wrapIndex(front)];
        items[wrapIndex(front)] = null;
        front++;
        size--;

        return itemToRemove;
    }

    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        if(size > startCap && size-1 < usedCapMin*(double)items.length) {
            shrink();
        }
        T itemToRemove = items[wrapIndex(back)];
        items[wrapIndex(back)] = null;
        back--;
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

    public int wrapIndex(int index) {
        if(index > 0 & index < items.length)
            return index;

        /* calculate wrapped index */
        if(index >= items.length) {
            return index - items.length;
        }
        if(index < 0) {
            return index + items.length;
        }
        return index;
    }

    public void resize(int newCap) {
        T[] newItems = (T[]) new Object[newCap];
        copyItems(newItems);
        items = newItems;
        front = (newItems.length / (resizeFactor * 2));
        back =  newItems.length - (newItems.length / (resizeFactor * 2));
    }

    public void resetIndex() {
        front = (items.length/2) - 1;
        back = (items.length/2) - 1;
    }

    public void copyItems(T[] newItems) {
        int offset = (newItems.length / (resizeFactor * 2)) ;

        for(int i = front; i <= back; i++) {
            newItems[offset++] = items[wrapIndex(i)];
        }
    }

    public void printDeque() {
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> a1 = new ArrayDeque<Integer>();

        for(int i = 0; i < 8; i++)
            a1.addLast(i);
        a1.printDeque();
        for(int i = 0; i < 8; i++)
            a1.removeLast();
        a1.printDeque();

        for(int i = 0; i < 8; i++)
            a1.addFirst(i);
        a1.printDeque();
        for(int i = 0; i < 8; i++)
            a1.removeFirst();
        a1.printDeque();

        for(int i = 0; i < 16; i++)
            a1.addFirst(i);
        a1.printDeque();
        for(int i = 0; i < 16; i++)
            a1.removeFirst();
        a1.printDeque();

//        for(int i = 0; i < 8; i++)
//            a1.addLast(i);

//        a1.addFirst(1);
//        a1.addLast(2);
//        a1.printDeque();
////        a1.removeFirst();
//        a1.removeLast();
//        a1.addLast(2);
//
//        a1.printDeque();
    }
}



