import java.util.Arrays;

public class Zombie {
    private static int mergeAndCount(int[] s, int low, int mid, int high) {

        // sub-arrays
        int[] s1 = Arrays.copyOfRange(s, low, mid + 1);
        int[] s2 = Arrays.copyOfRange(s, mid + 1, high + 1);

        int i = 0, j = 0, k = low;  // indexes
        int count = 0;

        while (i < s1.length && j < s2.length) {
            if (s1[i] > s2[j])
                s[k++] = s1[i++];

            // Offends the comparison.
            else {
                s[k++] = s2[j++];
                count += (mid + 1) - (low + i);
            }
        }

        while (i < s1.length)
            s[k++] = s1[i++];

        while (j < s2.length)
            s[k++] = s2[j++];

        return count;
    }

    private static int badCount(int[] s, int low, int high) {
        int count = 0;

        if (low < high) {
            int m = (low + high) / 2;

            // Subarray counts.
             count += badCount(s, low, m);
            count += badCount(s, m + 1, high);

            // Final count.
            count += mergeAndCount(s, low, m, high);
        }
        return count;
    }

    private static int badCount(int[] arr) {
        return badCount(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 1, 2, 3, 5};
        System.out.println(badCount(a, 0, a.length - 1));
    }

}
