import java.util.Arrays;
/*
* Logical argument to why this MinMax() has less that 3n/2 comparisons.
* ---------------------------------------------------------------------
* It first performs a split where the largest numbers are allocated to
* maxNums and the smallest numbers are allocated to minNums. This split
* does n/2 comparisons.
*
* It then performs n/2 - 1 comparisons when the n is even twice
* OR
* performs n/2 comparisons when n is odd twice
* for min and max.
*
* min and max stage when n is even = (n/2 - 1) + (n/2 - 1)  = 2n/2 - 2 comparisons
* OR
* min and max stage when n is odd = (n - 1)/2 + (n - 1)/2 = (2n - 2) / 2 comparisons
*
* which brings the total comparisons to
* n/2 + (2n/2 - 2) = 3n/2 - 2 OR n/2 + 2n - 2/2 = (3n - 3)/2
* which are both less than 3n/2.
* */

class MinMax{
    public static double minMaxAverage(int[] numbers) {
        if(numbers.length == 0) {
            return 0;
        }
        else if(numbers.length == 1) {
            return numbers[0];
        }
        else if(numbers.length == 2) {
            return (double)(numbers[0] + numbers[1]) / 2.0;
        }

        /* Debugging Print */
        boolean debug = false;
        int comparisons = 0;
        int allowedComparisons = (3 * numbers.length) / 2;;
        if(debug) {
            System.out.println("Running comparison count test.");
            System.out.println("Number of items: " + numbers.length);
            System.out.println("Allowed comparisons(3n/2): " + allowedComparisons);
        }

        /* Initial split of items[] to compute min and max separately. */
        double max, min;

        boolean isNumsRemainder = numbers.length % 2 != 0;
        int splitNumsSize = (numbers.length/2) + (isNumsRemainder ? 1 : 0); // adds 1 to accommodate remainder inside;

        int[] maxNums = new int[splitNumsSize];
        int[] minNums = new int[splitNumsSize];
        int maxNumsIdx = 0;
        int minNumsIdx = 0;

        /* Performs split. */
        for(int idx = 0; idx < numbers.length - (isNumsRemainder ? 1 : 0); idx += 2) {
            if(debug) comparisons++;  // count comparisons made

            int lhs = numbers[idx];
            int rhs = numbers[idx+1];

            if (lhs > rhs) {
                maxNums[maxNumsIdx++] = lhs;
                minNums[minNumsIdx++] = rhs;
            }
            else {
                maxNums[maxNumsIdx++] = rhs;
                minNums[minNumsIdx++] = lhs;
            }

        }
        /* copy the remainder if exists */
        if(isNumsRemainder) {
            maxNums[maxNumsIdx] = numbers[numbers.length - 1];
            minNums[minNumsIdx] = numbers[numbers.length - 1];
        }



        /* Initializing variables to iteratively compute the min and max */
        int[] nextBuf = new int[maxNums.length];                       // buffer to store maxNums and minNums for next iteration of pairing and purging.
        int nextBufIdx;                                                // buffer index.
        int iterations = (maxNums.length / 2) + (maxNums.length % 2);  // computes number of iterations needed to get final min and max.
        boolean isRemainder;                                           // computes if there is a remainder in a given iteration.

        /* Compute max iteratively */
        int maxNumsSize = maxNums.length;  // the number of items to compare for a given iteration.

        for(int currentIterations = 0; currentIterations < iterations; currentIterations++ ) {
            isRemainder = maxNumsSize % 2 != 0;
            nextBufIdx = 0;

            for (int idx = 0; idx < maxNumsSize - (isRemainder ? 1 : 0); idx += 2) {
                if(debug) comparisons++;  // count comparisons made


                int lhs = maxNums[idx];
                int rhs = maxNums[idx+1];

                if(lhs > rhs) {
                    nextBuf[nextBufIdx++] = lhs;
                }
                else {
                    nextBuf[nextBufIdx++] = rhs;
                }
            }
            if(isRemainder) {
                nextBuf[nextBufIdx] = maxNums[maxNumsSize-1];
            }

            /* updates how many numbers left in nextBuf */
            maxNumsSize = (maxNumsSize / 2) + (maxNumsSize % 2);
            maxNums = nextBuf;
        }
        max = maxNums[0];  // store max result


        /* Compute min iteratively */
        int minNumsSize = minNums.length;  // the number of items to compare for a given iteration.

        for(int currentIterations = 0; currentIterations < iterations; currentIterations++ ) {
            isRemainder = minNumsSize % 2 != 0;
            nextBufIdx = 0;

            for (int idx = 0; idx < minNumsSize - (isRemainder ? 1 : 0); idx += 2) {
                if(debug) comparisons++;  // count comparisons made

                int lhs = minNums[idx];
                int rhs = minNums[idx+1];

                if(lhs < rhs) {
                    nextBuf[nextBufIdx++] = lhs;
                }
                else {
                    nextBuf[nextBufIdx++] = rhs;
                }
            }
            if(isRemainder) {
                nextBuf[nextBufIdx] = minNums[minNumsSize-1];
            }

            /* updates how many numbers left in nextBuf */
            minNumsSize = (minNumsSize / 2) + (minNumsSize % 2);
            minNums = nextBuf;
        }
        min = minNums[0];  // store min result

        if(debug) {
            System.out.println("Counted comparisons: " + comparisons);
            if(comparisons < allowedComparisons) {
                System.out.println("Passed!");
            }
            else {
                System.out.println("Failed!");
            }
        }

        return (max + min) / 2.0; // avg min and max
    }
}


