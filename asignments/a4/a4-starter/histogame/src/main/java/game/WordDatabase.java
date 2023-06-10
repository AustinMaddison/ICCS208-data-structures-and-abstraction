package game;

import histogram.Histogram;

import java.io.*;
import java.util.*;

// HINT(s):
//   To read from src/resources/<filename>
//   InputStream is = getClass().getClassLoader().getResourceAsStream(filename);

public class WordDatabase implements IDatabase {
    private Set<Word> words;

    WordDatabase(String filename) {
        words = new HashSet<>();
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String word;
            // read words line by line and add to database
            while ((word = br.readLine()) != null) {
                Word newWord = new Word(word);
                words.add(newWord);
            }
        }
        catch (IOException e) {
            System.out.println("Couldn't read file:" + filename);
        }

    }


    @Override
    public void add(Word w) {
        words.add(w);
    }

    // Removes w from the database and has no effects if w is not present
    @Override
    public void remove(Word w) {
        words.remove(w);
    }

    // Returns a List of Words in the database whose length is exactly l.
    @Override
    public List<Word> getWordWithLength(int l) {
        List<Word> minLengthWords = new ArrayList<>();

        if (l == 0) {
            return minLengthWords;
        }

        for (Word word : this.words) {
            if (word.getHistogram().getTotalCount() >= l) {
                minLengthWords.add(word);
            }
        }

        return minLengthWords;
    }

    // Returns a List of Words in the database whose length is at least minLen
    // and which can be formed from all or some of the letters of the word w
    @Override
    public List<Word> getAllSubWords(Word w, int minLen) {
        List<Word> formableWords = new ArrayList<>();

        for (Word word : getWordWithLength(minLen)) {
            if (w.canForm(word)) {
                formableWords.add(word);
            }
        }

        return formableWords;
    }

    @Override
    public boolean contains(Word o) {
        return words.contains(o);
    }
}
