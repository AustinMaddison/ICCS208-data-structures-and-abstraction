package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void getWord() {
    }

    @Test
    void getHistogram() {
    }

    @Test
    void canForm() {

        String[][] l1 = {
            { "bbbdfsag" , "dfg"},
            { "lksdakjjbaa" , "aaab"},
            { "baaa" , "ab"},
            { "jkldkj" , "jjdlkk"},
            { "aaaajjfdajgkdjaaaaaa" , "aaa"},
        };

        Word[][] l1Words = Arr2DStringToWords(l1);

        for (Word[] i: l1Words ) {
            assertTrue(i[0].canForm(i[1]));
        }

    }




    Word[][] Arr2DStringToWords(String[][] words) {
        Word[][] l1Words = new Word[words.length][words[0].length];

        for (int i = 0; i < words.length; i++ ) {
            for(int j = 0; j < words[0].length; j++){
                l1Words[i][j] = new Word(words[i][j]);
            }

        }
        return l1Words;
    }


    @Test
    void compareTo() {
    }

    @Test
    void alphabeticallyBefore() {
        assertTrue(Word.isAlphabeticallyBefore("a", "b"));
        assertTrue(Word.isAlphabeticallyBefore("ab", "ac"));
        assertTrue(Word.isAlphabeticallyBefore("fg", "fz"));
        assertTrue(Word.isAlphabeticallyBefore("austin", "maddison"));
        assertTrue(Word.isAlphabeticallyBefore("acmn", "azkfl"));

        assertFalse(Word.isAlphabeticallyBefore("b", "a"));
        assertFalse(Word.isAlphabeticallyBefore("ac", "ab"));
        assertFalse(Word.isAlphabeticallyBefore("fz", "fg"));
        assertFalse(Word.isAlphabeticallyBefore("maddison", "austin"));
        assertFalse(Word.isAlphabeticallyBefore("alfk", "ab"));
    }
}