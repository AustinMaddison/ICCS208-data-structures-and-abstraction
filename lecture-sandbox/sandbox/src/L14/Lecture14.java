package L14;

import java.util.Arrays;
import java.util.Comparator;

public class Lecture14 {

    /* 1. Linear Search */
    public static int linearSearch(String[] array, String targetKey) {

        for (int i = 0; i < array.length; i++) {
            if (CharSequence.compare(targetKey, array[i]) == 0) {
                return i;
            }
        }

        return -1;

    }

    /* 2. Binary Search */
    private static int binarySearch(String[] array, String targetKey) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            // Recalculate middle position.
            int mid = (high - low) / 2 + low;

            if (CharSequence.compare(targetKey, array[mid]) < 0) {
                high = mid - 1;
            }
            if (CharSequence.compare(targetKey, array[mid]) > 0) {
                low = mid + 1;
            }

            // Found.
            if (CharSequence.compare(targetKey, array[mid]) == 0) {
                return mid;
            }
        }

        return -1;
    }

    /* 3. Running Time Recurrence */
    int primSum(int[] xs) {
        if (xs.length == 1) return xs[0];
        if (xs.length == 2) return xs[0] + xs[1];
        else {
            int[] ys = Arrays.copyOfRange(xs, 1, xs.length); // time of O(n) to copy array.
            return xs[0]+xs[1]+primSum(ys); // reduces n to n-1 for next iteration thus the amount of work is O( n(n-1) / 2)
        }
    }

    int whazIt(int[] ys) {
        if (ys.length == 0) return 0;
        if (ys.length == 1) return ys[0];
        int n = ys.length;
        int m = n/2;
        for (int i=0;i<n;i++) {
            int theSum = 0;
            for (int j=0;j<=i;j++) { theSum += ys[j]; }
            ys[i] = theSum;
        }
        int a = whazIt(Arrays.copyOfRange(ys, 0, m));
        int b = whazIt(Arrays.copyOfRange(ys, m, ys.length));  // split of arrays, divide and conquer therefor O(log(n))
        return a + b;
    }
}







