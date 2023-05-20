
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testOddPalindrome() {
        String word = "";

        for (int length = 0; length < 26; length++) {
            for (char middle = 'a'; middle < 'z'; middle++) {

                word += middle;
                int offset = 0;
                char letter = 'a';

                for (int idx = 0; idx < length; idx++) {

                    word = letter + word + letter;
                    letter++;
                }
                assertTrue(palindrome.isPalindrome(word));
                word = "";
            }
        }
    }


    @Test
    public void testEvenPalindrome() {
        String word = "";

        for (int length = 0; length < 26; length++) {

                char letter = 'a';
                for (int idx = 0; idx < length; idx++) {

                    word = letter + word + letter;
                    letter++;
                }

                assertTrue(palindrome.isPalindrome(word));
                word = "";
        }
    }





}

