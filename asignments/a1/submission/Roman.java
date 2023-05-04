/**
 * @author Austin Maadison
 * @date 27/04/2023
 */

public class Roman {
    public static int romanToInt(String romanNum) {
        int previous = 0, result = 0;

        /* Traverses the romanNum array backwards. */
        for(int index = romanNum.length()-1; index >= 0; index--) {
            int conversion = romanToIntLookup(romanNum.charAt(index));
            if(previous > conversion) {
                result -= conversion;
            }
            else {
                result += conversion;
            }
            previous = conversion;
        }

        return result;
    }

    public static int romanToIntLookup(char romanLetter){
        switch (romanLetter){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                System.out.printf("%c is not valid roman numeral", romanLetter);
                System.exit(-1);
                return 0;
        }
    }
}
