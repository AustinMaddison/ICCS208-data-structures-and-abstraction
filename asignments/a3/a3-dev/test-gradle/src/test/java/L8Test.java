import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L8Test {
    /* Every method with @Test will be treated as a test */
    // check Junit for functions ans stuff
    @Test
    void testSumIntA() {
        assertEquals( 5, L8.sumInt(2, 3));
        assertEquals( 32, L8.sumInt(16, 16));
    }

    @Test
    void testSumIntB() {
        assertEquals( 103, L8.sumInt(100, 3));
        assertEquals( 116, L8.sumInt(100, 16));
    }

    @Test
    void testFelineIsAlive() {
        Feline fe = new Feline(32, "dog");
        assertEquals(32, fe.w);
        assertEquals("dog", fe.name);
    }
}