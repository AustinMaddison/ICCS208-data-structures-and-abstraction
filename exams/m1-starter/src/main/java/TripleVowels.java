import java.util.HashMap;

public class TripleVowels {

    public static boolean hasTripleVowels(String st) {
        int count = 0;
        boolean isPrevVowel = false;
        char[] st_arr = st.toCharArray();

        for (char c: st_arr) {

            boolean isCurrentVowel = isVowel(c);

            // c is a vowel and the last c was not a vowel -> start count at 1.
            if ( isCurrentVowel & !isPrevVowel ) {
                isPrevVowel = true;
                count = 1;
            }

            // c is a vowel and the last c was a vowel -> increment count.
            else if (isCurrentVowel & isPrevVowel) {
                isPrevVowel = true;
                count++;
            }

            // c is not a vowel -> reset isPrevVowel and count.
            else {
                isPrevVowel = false;
                count = 0;
            }

            // return if 3 vowels are found.
            if ( count == 3 ) return true;
        }
        return false;
    }

    /**
     * @param c Letter to be determined as vowel.
     * @return Returns true if input character is a vowel.
     */
    private static boolean isVowel(char c){
        char[] validVowels = new char[] {'a', 'e', 'i', 'o', 'u' };

        for(int idx = 0; idx < validVowels.length; idx++) {
            if(Character.toLowerCase(c) == validVowels[idx]) {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        String[] tests     = {"fooo", "OoO", "baZaa", "fooA", "moraiene"};
        boolean[] expected = {true  , true , false  , true  ,  true};
        int numPassed = 0;
        for (int i=0;i<tests.length;i++) {
            boolean result = hasTripleVowels(tests[i]);
            if (result == expected[i]) 
                numPassed++;
        }
        System.out.printf("== Passed %d out of %d cases\n", numPassed, tests.length);
    }
}
