
public class Palindrome {

    // Returns a deque of chars from string.
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new ArrayDeque<Character>();

        for(int idx = 0; idx < word.length(); idx++) {
            wordDeque.addLast(word.charAt(idx));
        }

        return wordDeque;
    }

}
