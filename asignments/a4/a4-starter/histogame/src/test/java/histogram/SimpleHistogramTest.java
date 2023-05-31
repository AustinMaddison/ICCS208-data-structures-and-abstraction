package histogram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;


public class SimpleHistogramTest {

    @Test
    public void testHistogram() {
        Character[] target = {'a','b','c','a'};
        Histogram<Character> h = new SimpleHistogram<>(target);
        Iterator<Character> iter = h.iterator();
        int elemCount = 0;
        while(iter.hasNext()) {
            iter.next();
            elemCount++;
        }

        assertEquals(3, elemCount);
        assertEquals(2, h.getCount('a'));
        assertEquals(1, h.getCount('b'));
        assertEquals(1, h.getCount('c'));
        assertEquals(4, h.getTotalCount());

        Histogram<Character> h_copy = new SimpleHistogram<>(h);

        // Testing Deep Copy
        assertEquals(h.getTotalCount(), h_copy.getTotalCount());
        assertEquals(h_copy.getCount('a'), h.getCount('a'));
        assertEquals(h_copy.getCount('b'), h.getCount('b'));
        assertEquals(h_copy.getCount('c'), h.getCount('c'));
        assertEquals(h_copy.getTotalCount(), h.getTotalCount());
        System.out.println(h.equals(h_copy));

        h_copy.setCount('a', h.getCount('a') + 10);
        assertNotEquals(h_copy.getCount('a'), h.getCount('a'));

        System.out.println(h);
        System.out.println(h.equals(h_copy));

    }
}
