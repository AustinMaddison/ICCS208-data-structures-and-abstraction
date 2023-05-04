/**
 * @author Austin Maadison
 * @date 27/04/2023
 */

public class Happy {
    public static long sumOfDigitsSquared(long n) {
        long digits = n;

        long digit_extract = 0, result = 0;
        for (long i = 0; digits > 0; i++) {
            digit_extract = digits % 10;
            if (digit_extract == 0) {
                digits /= 10;
                continue;
            }
            digits -= digit_extract;
            result += Math.pow(digit_extract, 2);
        }
        return result;
    }

    public static boolean isHappy(long n) {

        for(long target = n; ; target = sumOfDigitsSquared(target)) {
            if(target == 1)
                return true;
            if(target == 4)
                return false;
        }
    }

    public static long[] firstK(int k) {

        long[] firstKarr = new long[k];
        int isHappyCount = 0;
        for(long i = 1; isHappyCount < k; i++) {
            if(isHappy(i))
                firstKarr[isHappyCount++] = i;
        }
        return firstKarr;
    }
}
