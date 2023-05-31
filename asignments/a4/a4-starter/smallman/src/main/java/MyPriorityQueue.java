import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MyPriorityQueue<T> implements IPriorityQueue<T>, Iterable<T> {
    private List<T> queue;
    private CompareWith<T> comparator;
    private Comparator<T> sortComparator;

    /**
     * @param comparator An object that implements CompareWith which has lessThan()
     *                   comparator function which will determine the priority of
     *                   the queue.
     */
    public MyPriorityQueue(CompareWith<T> comparator) {
        queue = new ArrayList<T>();
        this.comparator = comparator;

        sortComparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return MyPriorityQueue.this.comparator.lessThan(o1, o2) ? 1 : 0;
            }
        };
    }

    /**
     * Add item to queue.
     * @param item Item to be added to queue.
     */
    @Override
    public void add(T item) {

        // current queue is empty
        if(isEmpty()) {
            queue.add(item);
        }

        // Add item into queue where it is less than or equal to a subsequent element.
        else {
            int idx;
            for (idx = 0; idx < size(); idx++) {
                if (comparator.lessThan(item, queue.get(idx))) {
                    break;
                }
            }
            queue.add(idx, item);
        }
    }

    /**
     * Adds the list of items to the queue and replaces minimum
     * if there is a smaller minimum.
     * @param items List to be added to queue.
     */
    @Override
    public void addAll(List<T> items) {

        // Items is empty.
        if(items.size() == 0) {
            return;
        }

        // Items has single element.
        else if(items.size() == 1) {
            add(items.get(0));
        }

        // Queue is empty -> copy items into queue -> sort queue.
        else if(isEmpty()) {
            queue.addAll(items);
            sortQueue();
        }

        // Insert elements of items directly into queue.
        else {
            for(T item : items) add(item);
        }
    }

    private void sortQueue() {
        queue.sort(sortComparator);
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T getMinimum() {
        return queue.get(0);
    }

    @Override
    public void removeMinimum() {
        queue.remove(0);
    }

    @Override
    public int size() {
        return queue.size();
    }

    /**
     * @return Returns queue from the highest priority to the lowest priority.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyPriorityQueueIterator();
    }

    /**
     * @return Returns queue from the lowest priority to the highest priority.
     */
    @Override
    public Iterator<T> revIterator() {
        return new MyPriorityQueueIterator(true);
    }

    private class MyPriorityQueueIterator implements Iterator<T> {
        boolean isReverse;
        int currentIdx;

        /**
         * @param isReverse When set to true, it will return a reversed iterator.
         */
        MyPriorityQueueIterator(boolean isReverse) {
            this.isReverse = isReverse;
            currentIdx = isReverse ? size() - 1 : 0;
        }

        MyPriorityQueueIterator() {
            this(false);
        }

        @Override
        public boolean hasNext() {
            return isReverse ? currentIdx >= 0 : currentIdx < size();
        }

        @Override
        public T next() {
            // Returns current item from queue of currentIdx then increments or
            // de-increments currentIdx whether isReverse is true or false.
            return queue.get( isReverse ? currentIdx-- : currentIdx++);
        }
    }
}
