/**
 * @authour Austin Madison
 * @date 27/04/2023
 */

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
public class Exercise2 {
    /**
     * Exercise 1
     * @param n
     * @return number of trailing zeros of n factorial
     */
    public static int numTrailingZeros(int n) {

        int _n = n;
        BigInteger fact = BigInteger.valueOf(1);
        while(_n > 0) {
            fact = fact.multiply(BigInteger.valueOf(_n));
            --_n;
        }

        int count = 0;
        BigInteger powerTen = BigInteger.valueOf(10);
        while( 0 == (fact.mod(powerTen)).compareTo(BigInteger.ZERO)){
            ++count;
            powerTen= powerTen.multiply(BigInteger.valueOf(10));
        }

        return count;
    }

    /**
     * Exercise 2
     * @param a array of numbers
     * @param n size of summation as sum of a[i] through a[i + n]
     * @return number of trailing zeros of n factorial
     */
    public static void windowPosSum(int[] a, int n) {

        for(int index = 0; index < a.length - 1; index++) {
            if(a[index] > 0) {
                for(int offset = 1; offset <= n && offset + index < a.length; offset++) {
                    a[index] += a[offset+index];
                }
            }
        }
    }

}

