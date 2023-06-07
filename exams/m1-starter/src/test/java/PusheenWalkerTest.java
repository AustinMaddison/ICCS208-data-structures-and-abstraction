import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PusheenWalkerTest {

    private static<E> void iterCheck(List<List<E>> tb, E[] expected) {
        int k=0;
        for (E e: new PusheenWalker<>(tb)) {
            assertEquals(expected[k++], e);
        }
        assertEquals(expected.length, k);
    }

    @Test
    void simpleWalkerTest() {
        List<List<String>> list0 = List.of(
            List.of("5", "1", "5"),
            List.of("25", "25", "625")
        );



        String[] expected0 = {"5", "1", "5", "25", "25", "625"};
        iterCheck(list0, expected0);
        List<List<Integer>> list1 = List.of(
            List.of(),
            List.of(3, 7),
            List.of(),
            List.of(1),
            List.of(),
            List.of(),
            List.of(5, 0, 2)
        );
        Integer[] expected1 = {3, 7, 1, 5, 0, 2};
        iterCheck(list1, expected1);

        List<List<Double>> list2 = List.of();
        Double[] expected2 = {};
        iterCheck(list2, expected2);
    }
}
