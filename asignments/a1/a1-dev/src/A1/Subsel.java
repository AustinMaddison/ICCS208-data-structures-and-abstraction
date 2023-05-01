/**
 * @author Austin Maadison
 * @date 27/04/2023
 */

package A1;
public class Subsel {

    /**
     * @param a         an array of numbers.
     * @param stride    how many elements to skip in reading the array's walk.
     * @param beginWith the starting position of the walk.
     * @return an array depending on the array walk parameters.
     */
    public static int[] takeEvery(int[] a, int stride, int beginWith) {

        int inputSize = a.length;
        int resultSize = 0;

        if (stride == 0) {
            System.out.println("INVALID INPUT: stride must be a non-zero integer.");
            System.exit(-1);
        }
        else if (stride > 0 ) {
            resultSize = ((inputSize - beginWith) / stride) + ((((inputSize - beginWith) % (stride) > 0)) ? 1 : 0);
        }
        else {
            resultSize = ((beginWith+1) / Math.abs(stride)) + ((((beginWith+1) % Math.abs(stride)) > 0)  ? 1 : 0);
        }

        int[] result = new int[resultSize];

        for (int index = 0; index < resultSize; index++) {
            result[index] = a[beginWith + ((stride) * index)];
        }


        return result;
    }

    public static int[] takeEvery(int[] a, int stride) {
        return takeEvery(a, stride, 0);
    }

}
