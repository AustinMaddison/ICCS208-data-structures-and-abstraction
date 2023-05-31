import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundedSkipperTest {

    @Test
    public void testBoundedSkipper() {
        BoundedSkipper bs = new BoundedSkipper(11, 3);
        for(int n: bs) {
            System.out.println(n);
        }
    }

}