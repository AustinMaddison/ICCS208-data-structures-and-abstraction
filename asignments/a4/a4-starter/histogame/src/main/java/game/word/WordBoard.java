package game.word;

import java.util.*;

public class WordBoard {
    private WordDatabase wordDatabase;
    private List<Word> wordsOfMinLength; // list of words that determines the scrambled.
    private List<Word> wordList;
    private boolean[] correctWords;
    private String jumbledWord;

    private int minWordLength;
    private Random random;


    /**
     * Holds all the words the player has to guess to win the game.
     *
     * @param filename file name of word database to be used.
     */
    WordBoard(String filename, int minWord) {
        wordDatabase = new WordDatabase(filename);
        this.minWordLength = minWord;
        wordsOfMinLength = wordDatabase.getWordWithLength(minWordLength);

        initialize();
    }

    public WordBoard(String filename) {
        this(filename, 6);
    }

    public void initialize() {
        random = new Random();
        int randomIdx = random.nextInt(wordsOfMinLength.size());
        Word starterWord = wordsOfMinLength.get(randomIdx); // determines what will be the subwords.
        jumbledWord = jumbleString(starterWord.getWord());

        wordList = wordDatabase.getAllSubWords(starterWord, 1);
        wordList.sort(Word::compareTo);

        /* Set all words to hidden */
        correctWords = new boolean[wordList.size()];
        Arrays.fill(correctWords, false);
    }

    private String jumbleString(String word) {
        List<Character> list = new ArrayList<Character>();
        for (char c : word.toCharArray()) {
            list.add(Character.toLowerCase(c));
        }
        Collections.shuffle(list);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : list) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private void addAllWords(List<Word> words) {
        this.wordList.addAll(words);
    }

    public List<Word> getAllWords() {
        return wordList;
    }

    public int size() {
        return wordList.size();
    }

    public void makeCorrectAtIdx(int idx) {
        correctWords[idx] = true;
    }

    public boolean isCorrectAtIdx(int idx) {
        return correctWords[idx];
    }

    public String getJumbledWord() {
        return jumbledWord;
    }

    /**
     * @param o Word to compare
     * @return Returns the index of word if that word exists and -1 if it doesn't exist.
     */
    public int contains(Word o) {
        for(int i = 0; i < wordList.size(); i++) {
            if(wordList.get(i).compareTo(o) == 0) {
                return i;
            }
        }
        return -1;
    }
}
