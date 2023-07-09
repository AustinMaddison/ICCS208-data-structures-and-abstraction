package L17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyPriorityQueue<T> {

    List<T> pq;
    Comparator<T> cc;

    public MyPriorityQueue(Comparator<T> cc) {
        this.cc = cc;
        pq = new ArrayList<>();
        pq.add(null);
    }

    public void add(T elt) {
        pq.add(elt);
        swim(size());
    }

    public T findMax() {
        return pq.get(1);
    }

    public void removeMax() {
        swap(1, size());
        pq.remove(size());
        sink(1);
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public int size() {
        return pq.size()-1;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < pq.size(); i++)
            sb.append(pq.get(i)).append(" ");

        return sb.toString();
    }

    private void swim(int eltPos) {

        int curPos = eltPos;
        while (! isRoot(curPos)){
            if(cc.compare(pq.get(parentPosOf(curPos)), pq.get(curPos)) > 0) break;
            swap(parentPosOf(curPos), curPos);
            curPos = parentPosOf(curPos);
        }
    }

    private void sink(int eltPos) {

        int curPos = eltPos;
        while (! isLeaf(curPos)){
            int child = maxChildPos(curPos);
            if(cc.compare(pq.get(curPos), pq.get(child)) > 0) break;
            swap(child, curPos);
            curPos = child;
        }
    }

    private void swap(int eltPos1, int eltPos2) {
        T temp = pq.get(eltPos1);
        pq.set(eltPos1, pq.get(eltPos2));
        pq.set(eltPos2, temp);
    }

    private int parentPosOf(int eltPos) {
        return isRoot(eltPos) ? eltPos : eltPos / 2;
    }

    private boolean isLeaf(int eltPos) {
        return eltPos * 2 > size();
    }

    private boolean isRoot(int eltPos) {
        return eltPos == 1;
    }

    private int maxChildPos(int eltParPos) {
        if(eltParPos*2+1 > size())
            return eltParPos*2;
        else
            return cc.compare(pq.get(eltParPos*2), pq.get(eltParPos*2+1)) > 0 ? eltParPos*2 : eltParPos*2+1;
    }
    public static void main(String[] args) {

    }

}

