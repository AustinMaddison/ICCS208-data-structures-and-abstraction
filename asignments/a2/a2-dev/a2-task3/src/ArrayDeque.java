public class ArrayDeque <T>{

    private final int startCap = 8;
    private final double minUsedCap = 0.25;
    private final int resizeFactor = 2;
    private int front, back, size;

    T[] items;

    ArrayDeque() {
        items = (T[]) new Object[startCap];
        size = 0;
        front = 0;
        back = 0;
    }

    // Adds an item of type T to the front of the deque.
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
        for (int i = front; i - front < size; i++) {
            s = s + items[wrapIndex(i)] + ", ";
        }

        return s;
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
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

    public int getCapacity() {
        return items.length;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> a1 = new ArrayDeque<>();

        // testing if em

//        for(int i = 0; i < 16; i++) {
//            a1.addLast(i);
//        }
//        a1.printDeque();
//        for(int i = 0; i < 16; i++) {
//            a1.removeLast();
//        }
//        a1.printDeque();
//        System.out.println(a1.getCapacity());

        /* Test addFirst and removeLast */
//        for(int i = 0; i < 32; i++) {
//            a1.addFirst(i);
//            System.out.println(a1.getCapacity());
//
//            a1.printDeque();
//
//        }
//        a1.printDeque();
//        for(int i = 0; i < 32; i++) {
//            System.out.println(a1.removeFirst());
////            a1.removeFirst();
//            a1.printDeque();
//
//            System.out.println(a1.getCapacity());
//        }
//        a1.printDeque();
//        if ((a1.isEmpty() != true)) throw new AssertionError();


        /* Test addFirst and addLast */
//        for(int i = 0; i < 32; i++) {
//            a1.addLast(i);
//            System.out.println(a1.getCapacity());
//
//            a1.printDeque();
//
//        }
//        a1.printDeque();
//        for(int i = 0; i < 32; i++) {
//            System.out.println(a1.removeLast());
//            a1.printDeque();
//            System.out.println(a1.getCapacity());
//        }
//        a1.printDeque();
//
//        if ((a1.isEmpty() != true)) throw new AssertionError();


        /* Test addFirst and addLast alternating then removeLast */
        boolean flip = true;
        for(int i = 0; i < 32; i++) {
            if(flip)
                a1.addFirst(i);
            else
                a1.addLast(i);
            flip = !flip;
            System.out.println("Capacity: " + a1.getCapacity());

            a1.printDeque();

        }
        flip = !flip;
        a1.printDeque();
        int x;
        for(int i = 0; i < 32; i++) {
            x = a1.removeLast();
            System.out.println(x);
            a1.printDeque();
            System.out.println("Capacity: " + a1.getCapacity());
        }
        a1.printDeque();
        if ((a1.isEmpty() != true)) throw new AssertionError();

        /* Test addFirst and addLast alternating then removeFirst */
        flip = true;
        for(int i = 0; i < 32; i++) {
            if(flip)
                a1.addFirst(i);
            else
                a1.addLast(i);
            flip = !flip;
            System.out.println("Capacity: " + a1.getCapacity());

            a1.printDeque();

        }
        flip = !flip;
        a1.printDeque();
        for(int i = 0; i < 32; i++) {
            x = a1.removeFirst();
            System.out.println(x);
            a1.printDeque();
            System.out.println("Capacity: " + a1.getCapacity());
        }
        a1.printDeque();
        if ((a1.isEmpty() != true)) throw new AssertionError();


        /* Test addFirst and addLast alternating then alternating remove */
        flip = true;
        for(int i = 0; i < 32; i++) {
            if(flip)
                a1.addFirst(i);
            else
                a1.addLast(i);
            flip = !flip;
            System.out.println("Capacity: " + a1.getCapacity());

            a1.printDeque();

        }
        flip = !flip;
        a1.printDeque();
        for(int i = 0; i < 32; i++) {

            if(flip) {
                x = a1.removeFirst();
                System.out.println(x);
            }
            else {
                x = a1.removeLast();
                System.out.println(x);
            }
            flip = !flip;
            a1.printDeque();
            System.out.println("Capacity: " + a1.getCapacity());
        }
        a1.printDeque();
        if ((a1.isEmpty() != true)) throw new AssertionError();
    }


}