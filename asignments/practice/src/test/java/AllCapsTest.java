import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllCapsTest {

    @Test
    public void testAllCapLocations() {

        assertArrayEquals(AllCaps.allCapLocations("aAa"), new int[]{1});
        assertArrayEquals(AllCaps.allCapLocations("aAAa"), new int[]{1,2});


    }
}

