import java.math.BigInteger;

import static java.lang.Math.pow;

public class Fib {
    public static int firstNDigit(int n){
        if(n == 1) {
            return 1;
        }

        /* Uses modulo and power of 10s to compute least n digits position */
        BigInteger filter = BigInteger.valueOf(10).pow(n-1);
        int posNDigit = 4;
        BigInteger nMinusOne = BigInteger.valueOf(2);
        BigInteger nMinusTwo = BigInteger.valueOf(1);

        while(true){
            BigInteger nSum = nMinusOne.add(nMinusTwo);
            BigInteger nSumModFilter = nSum.mod(filter);
            if(nSumModFilter.compareTo(nSum) != 0)
                break;
            else {
                nMinusTwo = nMinusOne;
                nMinusOne = nSum;
                posNDigit++;
            }
        }
        return posNDigit;
    }
}
