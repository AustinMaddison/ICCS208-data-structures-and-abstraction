import java.lang.reflect.Array;
import java.util.Arrays;

public class Exercise2 {
    /**
     * Exercise 1
     * @param n
     * @return number of trailing zeros of n factorial
     */
    public static long numTrailingZeros(int n) {

        int _n = n;
        long fact = 1;
        while(_n > 0) {
            fact *=_n;
            --_n;
        }

        int count = 0;
        int powerTen = 10;
        while( (fact % powerTen) == 0){
            ++count;
            powerTen*=10;
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

        for(int i = 0; i < a.length - 1; i++) {
            if(a[i] > 0) {
                for(int j = 1; j <= n && j + i < a.length; j++) {
                    a[i] += a[j+i];
                }
            }
        }
    }

}

