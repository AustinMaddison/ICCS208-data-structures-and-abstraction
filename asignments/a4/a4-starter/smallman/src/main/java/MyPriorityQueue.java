import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyPriorityQueue<T> implements IPriorityQueue<T> {
    private List<T> queueItems;
    private CompareWith<T> cc;
    private int idxMin;

    public MyPriorityQueue(CompareWith<T> cc) {
        queueItems = new ArrayList<T>();
        this.cc = cc;
        idxMin = 0;  // first item added will always be min.
    }

    @Override
    public void add(T item) {
        // check if new item can replace current minimum
        if(size() > 0) {
            if(cc.lessThan(item, queueItems.get(idxMin))) {
                idxMin = size();
            }
        }
        queueItems.add(item);
    }

    @Override
    public void addAll(List<T> items) {

    }

    @Override
    public T getMinimum() {
        return queueItems.get(idxMin);
    }

    @Override
    public void removeMinimum() {
        queueItems.remove(idxMin);
    }

    private T getMinimumOfList() {

    }

    @Override
    public int size() {
        return queueItems.size();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Iterator<T> revIterator() {
        return null;
    }
}
