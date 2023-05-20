
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testOffByOneComparatorTrue() {
        for(char letter = 'a'; letter < 'z'; letter++ ) {
            char lhs = letter;
            char rhs = (char)(letter + 1);

            assertTrue(offByOne.equalChars(lhs,rhs));
            assertTrue(offByOne.equalChars(rhs,lhs));
            assertTrue(offByOne.equalChars(Character.toUpperCase(rhs),Character.toUpperCase(lhs)));
            assertTrue(offByOne.equalChars(Character.toUpperCase(lhs),Character.toUpperCase(rhs)));
        }
    }

    @Test
    public void testOffByOneComparatorFalse() {
        for( int offset = -3; offset < offset * -1; offset++) {

            if(Math.abs(offset) == 1)
                continue;

            for (char letter = 'a'; letter < 'z'; letter++) {
                char lhs = letter;
                char rhs = (char) (letter + offset);

                assertFalse(offByOne.equalChars(lhs, rhs));
                assertFalse(offByOne.equalChars(rhs, lhs));
                assertFalse(offByOne.equalChars(Character.toUpperCase(rhs), Character.toUpperCase(lhs)));
                assertFalse(offByOne.equalChars(Character.toUpperCase(lhs), Character.toUpperCase(rhs)));
            }
        }
    }
} 
