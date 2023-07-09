package L17;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MyPriorityQueueTest {

    @Test
    public void PqTest() {
        Comparator<Integer> cc = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(cc);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(5);
        pq.add(6);
        System.out.println(pq);
    }

}