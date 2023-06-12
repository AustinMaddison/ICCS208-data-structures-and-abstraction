package game;

import game.word.WordDatabase;
import org.junit.jupiter.api.Test;

class WordDatabaseTest {

    @Test
    public void testReadFromFile() {
        WordDatabase wordDatabase = new WordDatabase("testwords.txt");
        System.out.println(wordDatabase.getWordWithLength(1));
    }

}