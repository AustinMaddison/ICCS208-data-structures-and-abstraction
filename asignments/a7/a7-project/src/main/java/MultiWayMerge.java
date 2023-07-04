import java.util.LinkedList;
import java.util.PriorityQueue;

public class MultiwayMerge {
    public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(LinkedList<Integer> list: lists) {
            for(int i = list.size(); i>0; i--) {
                pq.add(list.remove());
            }
        }

        LinkedList<Integer> sortedList = new LinkedList<>();
        for(int i = pq.size(); i> 0; i--)
            sortedList.add(pq.poll());

        return sortedList;
    }




}
