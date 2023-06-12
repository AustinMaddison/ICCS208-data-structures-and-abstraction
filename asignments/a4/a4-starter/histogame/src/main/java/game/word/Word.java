package game.word;

import histogram.Histogram;
import histogram.SimpleHistogram;

public class Word implements Formable<Word>, Comparable<Word> {
    private Histogram<Character> histogram;
    private String word;

    // The only constructor of the class, which takes a String representation
    // of the word. The histogram is generated here from the given word.
    public Word(String word) {
        this.word = word;
        Character[] wordToCharArr = new Character[word.length()];

        // word string to char array
        for (int idx = 0; idx < word.length(); idx++) {
            wordToCharArr[idx] = word.charAt(idx);
        }

        histogram = new SimpleHistogram<>(wordToCharArr);
    }

    // Returns the String representation of the word.
    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return getWord();
    }

    // Returns a Histogram describing the character distribution of the word.
    public Histogram<Character> getHistogram() {
        return histogram;
    }

    // Returns true if the Word represented by other can be formed using some
    // or all of the characters of this word.
    @Override
    public boolean canForm(Word other) {
        int characterFreqMatches = 0;

        // match frequencies and count
        for (Character key : other.histogram) {
            if (other.histogram.getCount(key) <= this.histogram.getCount(key)) {
                characterFreqMatches += other.histogram.getCount(key);
            }
            if (other.histogram.getTotalCount() == characterFreqMatches) {
                return true;
            }
        }

        return false;
    }

    /** Return -1 if this word is shorter than the word represented by o OR
    // when this word and the word represented by o have the same length but
    // this word comes before the word represented by o alphabetically.
    // Return zero if this word and o word are identical.
    // Return +1 otherwise.
     */
    @Override
    public int compareTo(Word o) {
        if (word.length() < o.word.length() | (word.length() == o.word.length() & isAlphabeticallyBefore(word, o.word))) {
            return -1;
        }
        if(word.equals(o.word)) {
            return 0;
        }
        else {
            return 1;
        }
    }

    static public boolean isAlphabeticallyBefore(String a, String b) {
        return a.compareToIgnoreCase(b)  < 0;
    }


}
