import java.util.Arrays;

class MinMax{
    public static double minMaxAverage(int[] numbers) {
        if(numbers.length == 0)
            return 0;
        if(numbers.length == 1)
            return numbers[0];

        /* Debug: counts and prints the amount of comparisons taking place */
        boolean debug = true;
        int debugCount = 0;

        int min, max;

        /* numbersPurged will store all numbers excluding min, so later in computing max can use 1 less comparison */
        int purgedIndex = 0;
        int[] numbersPurged = new int[numbers.length - 1];

        int[] numbersCurrent = Arrays.copyOf(numbers, numbers.length);
        int[] numbersNext;

        /* Computes min using n-1 comparisons */
        while(numbersCurrent.length != 1) {
            int currentSize = numbersCurrent.length;
            boolean isCurrentEven = currentSize % 2 == 0;
            numbersNext = new int[ ( currentSize % 2 == 0 ) ? currentSize / 2 : (currentSize / 2) + 1];

            for(int index = 0; index*2 < (isCurrentEven ? currentSize : currentSize - 1); index++) {
                if(debug) ++debugCount;
                if (numbersCurrent[index * 2] > numbersCurrent[index * 2 + 1]) {
                    numbersNext[index] = numbersCurrent[index * 2 + 1];
                    numbersPurged[purgedIndex++] = numbersCurrent[index * 2];
                }
                else {
                    numbersNext[index] = numbersCurrent[index * 2];
                    numbersPurged[purgedIndex++] = numbersCurrent[index * 2 + 1];
                }
            }
            if(!isCurrentEven)
                numbersNext[numbersNext.length - 1] = numbersCurrent[currentSize - 1];
            numbersCurrent = numbersNext;
        }
        min = numbersCurrent[0];

        /* Using purged to computer max numbers only reducing the number of comparisons by 1 */
        /* Computes max with n-2 comparisons */
        numbersCurrent = numbersPurged;
        while(numbersCurrent.length != 1) {
            int currentSize = numbersCurrent.length;
            boolean isCurrentEven = currentSize % 2 == 0;
            numbersNext = new int[ ( currentSize % 2 == 0 ) ? currentSize / 2 : (currentSize / 2) + 1];

            for(int index = 0; index*2 < (isCurrentEven ? currentSize : currentSize - 1); index++) {
                if(debug) ++debugCount;
                if (numbersCurrent[index * 2] < numbersCurrent[index * 2 + 1]){
                    numbersNext[index] = numbersCurrent[index * 2 + 1];
                }
                else {
                    numbersNext[index] = numbersCurrent[index * 2];
                }
            }
            if(!isCurrentEven)
                numbersNext[numbersNext.length - 1] = numbersCurrent[currentSize - 1];
            numbersCurrent = numbersNext;
        }
        max = numbersCurrent[0];

        if(debug) System.out.printf("Purged numbers are:\n%s\n", Arrays.toString(numbersPurged));
        if(debug) System.out.printf("Number of allowed comparisons: %f\n", (3 * numbers.length) / 2.0 );
        if(debug) System.out.printf("Number of used comparisons: %d\n", debugCount);
        return (min + max) / 2.0;
    }

    public static void main(String[] args) {
//        int[] a = {2, 3, 0, -20, 5, 5, 6, 1, -1, 6, 10};
//        int[] a = {2, 3, 0, -20, 10, 100};
//        int[] a = {69, 46, 79, 25, 93, 59, 65, 99, 60, 70, 1, 78, 52, 68, 82, 89, 78, 90, 65, 47};

//        assert(minMaxAverage({}) == 400);

//        double min = min(a);
//        double max = max(a);
//        double avg = minMaxAverage(a);

//        System.out.println(min);
//        System.out.println(max);
//        System.out.println(avg);

        if(true){
            if (minMaxAverage(new int[]{92, 40, 74, 84, 63, 80, 37, 80, 74, 20, 7}) != 49.5) throw new AssertionError();
            if (minMaxAverage(new int[]{23, 75, 100, 38, 68, 68, 22, 78, 23, 86}) != 61.0) throw new AssertionError();
            if (minMaxAverage(new int[]{40, 49, 64, 3, 45, 69, 24, 36, 31, 62, 3, 8, 9, 54, 78}) != 40.5) throw new AssertionError();
            if (minMaxAverage(new int[]{37, 58, 75, 2, 82, 9, 68, 5, 21}) != 42.0) throw new AssertionError();
            if (minMaxAverage(new int[]{2, 98}) != 50.0) throw new AssertionError();
            if (minMaxAverage(new int[]{12, 93, 4, 76, 85, 8, 53, 10, 73, 5, 30, 75, 1, 67, 28, 25}) != 47.0) throw new AssertionError();
            if (minMaxAverage(new int[]{31, 76, 30, 76, 86, 73, 92, 18, 36, 84, 85, 22, 39, 9, 26, 16, 25, 85, 67}) != 50.5) throw new AssertionError();
            if (minMaxAverage(new int[]{40, 25, 23}) != 31.5) throw new AssertionError();
            if (minMaxAverage(new int[]{10, 14, 83, 84, 84, 44}) != 47.0) throw new AssertionError();
            if (minMaxAverage(new int[]{23, 73, 30, 75, 75}) != 49.0) throw new AssertionError();
            if (minMaxAverage(new int[]{91, 96, 86, 38, 73, 9, 77, 28, 77, 13, 18, 85, 25, 73, 91, 14}) != 52.5) throw new AssertionError();
            if (minMaxAverage(new int[]{95, 8, 29, 25, 40, 41, 6, 5}) != 50.0) throw new AssertionError();
            if (minMaxAverage(new int[]{4, 77, 88, 64, 47, 24, 13}) != 46.0) throw new AssertionError();
            if (minMaxAverage(new int[]{81}) != 81.0) throw new AssertionError();
            if (minMaxAverage(new int[]{16, 19, 73, 93}) != 54.5) throw new AssertionError();
            if (minMaxAverage(new int[]{85, 12, 55, 14, 13, 9, 18}) != 47.0) throw new AssertionError();
            if (minMaxAverage(new int[]{68, 17, 27, 66}) != 42.5) throw new AssertionError();
            if (minMaxAverage(new int[]{52, 98, 90, 64, 86, 24, 83, 67, 100, 7, 87, 93}) != 53.5) throw new AssertionError();
            if (minMaxAverage(new int[]{74, 15, 42, 37, 34, 50, 47, 38, 41, 42, 70, 53, 96, 6, 96, 58, 85, 19}) != 51.0) throw new AssertionError();
            if (minMaxAverage(new int[]{35, 60}) != 47.5) throw new AssertionError();
            if (minMaxAverage(new int[]{70, 71, 50}) != 60.5) throw new AssertionError();
            if (minMaxAverage(new int[]{22, 97, 56, 7, 97, 6, 3, 11, 85, 22, 63, 72}) != 50.0) throw new AssertionError();
            if (minMaxAverage(new int[]{1, 84, 14, 23, 26}) != 42.5) throw new AssertionError();
            if (minMaxAverage(new int[]{65, 4, 97, 73, 47, 7, 54}) != 50.5) throw new AssertionError();
            if (minMaxAverage(new int[]{53, 40, 21, 15, 39, 24, 70, 41, 55, 12, 16}) != 41.0) throw new AssertionError();
            if (minMaxAverage(new int[]{94, 59, 51, 93}) != 72.5) throw new AssertionError();
            if (minMaxAverage(new int[]{11, 52, 70}) != 40.5) throw new AssertionError();
            if (minMaxAverage(new int[]{22, 76, 52, 60, 24, 58, 6}) != 41.0) throw new AssertionError();
            if (minMaxAverage(new int[]{30, 51, 91, 12, 68, 38, 97, 97, 62, 56, 93, 46, 22, 84}) != 54.5) throw new AssertionError();
            if (minMaxAverage(new int[]{73, 59, 8, 30, 93, 50, 48, 42, 73, 25}) != 50.5) throw new AssertionError();
            if (minMaxAverage(new int[]{65, 71, 23, 78, 44, 47, 20, 47, 59, 29, 39, 80, 38, 58, 26, 27, 59}) != 50.0) throw new AssertionError();
            if (minMaxAverage(new int[]{81, 51, 41, 24, 11, 23, 94, 1, 3, 98, 55, 69, 47}) != 49.5) throw new AssertionError();
            if (minMaxAverage(new int[]{60, 13, 90, 75, 90, 21, 79, 8, 62, 96, 9, 56}) != 52.0) throw new AssertionError();
            if (minMaxAverage(new int[]{52, 25, 35}) != 38.5) throw new AssertionError();
            if (minMaxAverage(new int[]{90}) != 90.0) throw new AssertionError();
            if (minMaxAverage(new int[]{34, 93, 80, 90, 35, 97, 44, 87, 86, 83, 92, 18, 81, 75}) != 57.5) throw new AssertionError();
            if (minMaxAverage(new int[]{93, 64, 42, 33, 15, 45, 99, 29, 74, 23, 46, 19, 9, 89, 46}) != 54.0) throw new AssertionError();
            if (minMaxAverage(new int[]{82, 52, 79, 31, 60, 97, 5, 29, 39, 87, 80, 27, 17, 7, 88, 67, 34, 82, 86}) != 51.0) throw new AssertionError();
            if (minMaxAverage(new int[]{18, 20, 56, 27, 44, 13, 25, 40, 33, 91, 71, 16, 100, 15}) != 56.5) throw new AssertionError();
            if (minMaxAverage(new int[]{74, 59, 32, 4, 18, 18, 90}) != 47.0) throw new AssertionError();
            if (minMaxAverage(new int[]{36, 71, 58, 72, 57, 75, 4, 15, 85, 80, 34, 92, 67, 57, 44, 22, 61}) != 48.0) throw new AssertionError();
            if (minMaxAverage(new int[]{20, 33, 31, 31, 76, 26, 89, 25, 52, 58, 69, 60}) != 54.5) throw new AssertionError();
            if (minMaxAverage(new int[]{79, 45, 58}) != 62.0) throw new AssertionError();
            if (minMaxAverage(new int[]{80, 24, 23, 49, 11, 85, 55, 16, 72, 85, 4, 50, 94, 73, 34, 27, 56, 70, 68, 34}) != 49.0) throw new AssertionError();
            if (minMaxAverage(new int[]{52, 76, 74, 95, 5, 44, 98, 89, 6, 91, 94, 98, 51, 23, 54, 19, 67, 60}) != 51.5) throw new AssertionError();
            if (minMaxAverage(new int[]{90, 92, 44, 13, 14, 67}) != 52.5) throw new AssertionError();
            if (minMaxAverage(new int[]{63, 90, 50, 27, 5, 85, 19, 68, 58, 93, 63, 93, 74, 53, 92, 84, 72}) != 49.0) throw new AssertionError();
            if (minMaxAverage(new int[]{99, 53, 99, 61, 7, 44, 54, 52, 74, 95, 78, 33, 45, 15, 29, 44}) != 53.0) throw new AssertionError();
            if (minMaxAverage(new int[]{42, 20, 66, 100, 9, 21, 58, 26, 53, 48, 56, 76, 47, 26, 56, 50}) != 54.5) throw new AssertionError();
            if (minMaxAverage(new int[]{90, 39, 29, 12, 69, 63, 43}) != 51.0) throw new AssertionError();
            if (minMaxAverage(new int[]{25, 44, 25, 53, 72, 78, 52, 14, 56, 74, 56, 16, 80, 1, 65, 50, 81}) != 41.0) throw new AssertionError();
            if (minMaxAverage(new int[]{35, 16, 48, 22, 67, 79, 67, 81, 46, 80, 4, 62, 56, 58, 49, 88, 2, 2}) != 45.0) throw new AssertionError();
            if (minMaxAverage(new int[]{63, 21, 22, 63, 23, 56, 44, 75, 92, 95, 23, 33, 55, 33, 23, 2, 47}) != 48.5) throw new AssertionError();
            if (minMaxAverage(new int[]{78, 69, 41, 90, 33, 98, 63, 82}) != 65.5) throw new AssertionError();
            if (minMaxAverage(new int[]{95, 69, 50}) != 72.5) throw new AssertionError();
            if (minMaxAverage(new int[]{3, 56, 14, 50, 47, 98, 83, 76, 17, 79, 39, 60}) != 50.5) throw new AssertionError();
            if (minMaxAverage(new int[]{92}) != 92.0) throw new AssertionError();
            if (minMaxAverage(new int[]{26, 15, 56, 45, 54, 79}) != 47.0) throw new AssertionError();
            if (minMaxAverage(new int[]{70, 54, 7, 2}) != 36.0) throw new AssertionError();
            if (minMaxAverage(new int[]{96, 82}) != 89.0) throw new AssertionError();
            if (minMaxAverage(new int[]{95, 28, 37, 81, 10, 89}) != 52.5) throw new AssertionError();
            if (minMaxAverage(new int[]{55}) != 55.0) throw new AssertionError();
            if (minMaxAverage(new int[]{41, 73, 74, 92, 74, 2, 95, 89, 1, 82, 53, 81}) != 48.0) throw new AssertionError();
            if (minMaxAverage(new int[]{14, 11, 18}) != 14.5) throw new AssertionError();
            if (minMaxAverage(new int[]{98, 28, 24, 28, 53, 49, 98, 61, 76, 76, 30, 72, 19, 66}) != 58.5) throw new AssertionError();
            if (minMaxAverage(new int[]{37, 57, 3, 54, 20, 86, 41, 46, 6, 83, 30, 41, 86, 56, 79, 63, 47}) != 44.5) throw new AssertionError();
            if (minMaxAverage(new int[]{23, 23, 24, 66, 71, 53, 85, 59, 29, 4, 42}) != 44.5) throw new AssertionError();
            if (minMaxAverage(new int[]{67, 98, 17, 95, 49, 83, 84, 38, 15, 65, 56, 46, 86, 32, 26, 80}) != 56.5) throw new AssertionError();
            if (minMaxAverage(new int[]{84, 24, 53, 34, 55, 13, 5, 70, 1, 32, 16, 80, 65, 53}) != 42.5) throw new AssertionError();
            if (minMaxAverage(new int[]{85, 33, 86, 19, 81, 97, 62, 60, 84, 37, 83, 81, 89, 67}) != 58.0) throw new AssertionError();
            if (minMaxAverage(new int[]{1, 91, 39, 52, 82, 69}) != 46.0) throw new AssertionError();
            if (minMaxAverage(new int[]{48, 43, 60, 87, 8, 57, 74, 29, 37}) != 47.5) throw new AssertionError();
            if (minMaxAverage(new int[]{49, 56, 25, 11, 41, 31, 14, 53, 24, 53, 94, 65, 24, 30, 36, 35, 47, 64, 32, 32}) != 52.5) throw new AssertionError();
            if (minMaxAverage(new int[]{75, 29, 24, 2, 67, 21, 4, 6, 23, 71, 90, 19, 59, 28, 40, 87}) != 46.0) throw new AssertionError();
            if (minMaxAverage(new int[]{15, 88, 58, 60, 3, 9, 2, 82, 51, 60, 65, 85, 100, 52, 13}) != 51.0) throw new AssertionError();
            if (minMaxAverage(new int[]{79, 93, 75, 6, 95, 85, 53, 88, 6, 5, 70, 98, 13, 66, 94, 46}) != 51.5) throw new AssertionError();
            if (minMaxAverage(new int[]{74, 26, 62, 66, 48, 84, 56, 52, 85, 59, 46, 58}) != 55.5) throw new AssertionError();
            if (minMaxAverage(new int[]{97, 34, 33}) != 65.0) throw new AssertionError();
            if (minMaxAverage(new int[]{19, 85, 12, 91, 51, 12, 90, 61, 55, 5, 56, 100, 64, 89, 87, 93, 66, 89, 36, 38}) != 52.5) throw new AssertionError();
            if (minMaxAverage(new int[]{4, 89, 51, 15, 35, 54, 73, 79, 93, 83, 18, 43, 34, 58, 73}) != 48.5) throw new AssertionError();
            if (minMaxAverage(new int[]{12, 45, 14, 87, 83, 16, 86, 22, 97, 11, 26, 37, 61, 18, 51}) != 54.0) throw new AssertionError();
            if (minMaxAverage(new int[]{10, 43, 45}) != 27.5) throw new AssertionError();
            if (minMaxAverage(new int[]{51, 35, 23, 80, 16, 87}) != 51.5) throw new AssertionError();
            if (minMaxAverage(new int[]{77, 29, 79, 10, 83, 17, 64, 19, 43}) != 46.5) throw new AssertionError();
            if (minMaxAverage(new int[]{23, 49, 9, 2, 33, 30, 40, 100, 14, 1, 21, 89}) != 50.5) throw new AssertionError();
            if (minMaxAverage(new int[]{31, 81, 38, 24, 16, 54, 44, 59}) != 48.5) throw new AssertionError();
            if (minMaxAverage(new int[]{70, 28, 76, 3, 59, 30, 34, 12, 41, 99, 81}) != 51.0) throw new AssertionError();
            if (minMaxAverage(new int[]{44, 60, 23, 70, 8, 21}) != 39.0) throw new AssertionError();
            if (minMaxAverage(new int[]{13, 50, 80, 35, 79}) != 46.5) throw new AssertionError();
            if (minMaxAverage(new int[]{13, 69, 52, 55, 18, 92, 50, 75}) != 52.5) throw new AssertionError();
            if (minMaxAverage(new int[]{89, 22, 34, 15, 58, 11, 54, 98, 66}) != 54.5) throw new AssertionError();
            if (minMaxAverage(new int[]{50}) != 50.0) throw new AssertionError();
            if (minMaxAverage(new int[]{72, 22, 44, 56, 42, 43, 18, 50, 31, 6, 13, 31, 47, 16, 69, 4, 2, 24, 19}) != 37.0) throw new AssertionError();
            if (minMaxAverage(new int[]{60, 58, 79, 29}) != 54.0) throw new AssertionError();
            if (minMaxAverage(new int[]{36, 16, 57, 1}) != 29.0) throw new AssertionError();
            if (minMaxAverage(new int[]{4, 73, 37, 31, 92, 53, 36, 95, 55, 55, 78, 43}) != 49.5) throw new AssertionError();
            if (minMaxAverage(new int[]{9, 26, 39, 99, 44}) != 54.0) throw new AssertionError();
            if (minMaxAverage(new int[]{11, 50, 70, 11, 86, 48, 68, 34, 88}) != 49.5) throw new AssertionError();
            if (minMaxAverage(new int[]{5, 96, 38, 76, 43, 51, 30, 44, 5, 98, 54, 95, 39, 53, 91, 90}) != 51.5) throw new AssertionError();
            if (minMaxAverage(new int[]{51, 14, 2, 9, 51, 91}) != 46.5) throw new AssertionError();
        }



    }
}
