package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordDatabaseTest {

    @Test
    public void testReadFromFile() {
        WordDatabase wordDatabase = new WordDatabase("testwords.txt");
        System.out.println(wordDatabase.getWordWithLength(1));
    }

}