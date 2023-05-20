
public class Palindrome {

    // Returns a deque of chars from string.
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new ArrayDeque<Character>();

        for(int idx = 0; idx < word.length(); idx++) {
            wordDeque.addLast(word.charAt(idx));
        }

        return wordDeque;
    }

    // Returns true if a word is a palindrome.
    public boolean isPalindrome(String word) {
        CharacterComparator offByZero = new OffByN(0);
        return isPalindrome(word, offByZero);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        boolean isPalindrome = true;

        for(int idx = 0; idx < wordDeque.size() / 2; idx++) {
            isPalindrome = cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast()) && isPalindrome;
        }

        return isPalindrome;
    }




}
