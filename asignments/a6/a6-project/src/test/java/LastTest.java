import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastTest {

    @Test
    void binarySearchLastTest() {
        int[] a = {1,2,2,2,4,5};
        System.out.println(Last.binarySearchLast(a, 2));
    }
}