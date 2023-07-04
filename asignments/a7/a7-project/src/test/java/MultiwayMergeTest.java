import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiwayMergeTest {

    @Test
    public void testMerge(){
        LinkedList<Integer> LL1 = new LinkedList<>();
        LL1.addAll(List.of(9,10,11,13,17));

        LinkedList<Integer> LL2 = new LinkedList<>();
        LL2.addAll(List.of(1,2,5));

        LinkedList<Integer> LL3 = new LinkedList<>();

        LinkedList<Integer> LL4 = new LinkedList<>();
        LL4.addAll(List.of(0));

        LinkedList<Integer> LL5 = new LinkedList<>();
        LL5.addAll(List.of(3,7));

        int arraysize = 5;

        LinkedList<Integer>[] lists = (LinkedList<Integer>[]) new LinkedList<?>[arraysize];

        lists[0] = LL1;
        lists[1] = LL2;
        lists[2] = LL3;
        lists[3] = LL4;
        lists[4] = LL5;
        LinkedList<Integer> returnlist  = MultiwayMerge.mergeAll(lists);
        int size = returnlist.size(), i = 0;
        while (i<size){
            System.out.println(returnlist.get(i++));
        }
    }
}