import java.util.LinkedList;
import java.util.PriorityQueue;

public class MultiwayMerge {

    public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all keys to priority queue, priority queue.
        for(LinkedList<Integer> list: lists) {
            for(int i = list.size(); i>0; i--) {
                pq.add(list.remove());
            }
        }
        LinkedList<Integer> sortedList = new LinkedList<>();

        // Pop off all the minimum values from the priority queue into a list.
        for(int i = pq.size(); i> 0; i--)
            sortedList.add(pq.poll());

        return sortedList;
    }




}
