import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountIfTest {

    @Test
    void testCount() {
        Predicate operator = new isEven();

        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        CountIf<Integer> c = new CountIf<Integer>(operator);
        assertEquals(c.count(a), 5
        );


    }
}