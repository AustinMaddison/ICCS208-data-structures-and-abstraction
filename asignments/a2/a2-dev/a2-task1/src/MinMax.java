import java.util.Arrays;

class MinMax{
    public static double minMaxAverage(int[] numbers) {

        int min, max;
        int min_index;

        int[] numbersCurrent = Arrays.copyOf(numbers, numbers.length);
        int[] numbersNext;

        int[] indexesCurrent = new int[numbers.length];
        int[] indexesNext;

        /* keeps tracks of indexes during purging of numbers */
        for(int index = 0; index < numbers.length; index++)
            indexesCurrent[index] = index;

        while(numbersCurrent.length != 1) {
            int currentPair = 0;
            int currentSize = numbersCurrent.length;
            boolean isCurrentEven = currentSize % 2 == 0;
            numbersNext = new int[ ( currentSize % 2 == 0 ) ? currentSize / 2 : (currentSize / 2) + 1];
            indexesNext = new int[numbersNext.length];

            for(int index = 0; index*2 < (isCurrentEven ? currentSize : currentSize - 1); index++) {
                if (numbersCurrent[index * 2] > numbersCurrent[index * 2 + 1]){
                    numbersNext[index] = numbersCurrent[index * 2 + 1];
                    indexesNext[index] = indexesCurrent[index * 2 + 1];
                }
                else {
                    numbersNext[index] = numbersCurrent[index * 2];
                    indexesNext[index] = indexesCurrent[index * 2];
                }
            }
            if(!isCurrentEven) {
                numbersNext[numbersNext.length - 1] = numbersCurrent[currentSize - 1];
                indexesNext[indexesNext.length - 1] = indexesCurrent[currentSize - 1];
            }
            numbersCurrent = numbersNext;
            indexesCurrent = indexesNext;
        }
        min = numbersCurrent[0];


        return min;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 0, -20, 5, 5, 6, 1, -1, 6, 10};
//        int[] a = {16, 6, 47, 51, 56, 8, 27, 97, 77, 19, 41, 99, 91, -1, 31, 42, 33, 38};

//        assert(minMaxAverage({}) == 400);

//        double min = min(a);
//        double max = max(a);
        double avg = minMaxAverage(a);

//        System.out.println(min);
//        System.out.println(max);
        System.out.println(avg);


        if(false){
            if (minMaxAverage(new int[]{16, 6, 47, 51, 56, 8, 27, 97, 77, 19, 41, 99, 91, 96, 31, 42, 33, 38}) != 55.5) throw new AssertionError();
            if (minMaxAverage(new int[]{30, 35}) != 47.5) throw new AssertionError();
            if (minMaxAverage(new int[]{52, 70, 13, 43, 18}) != 48.0) throw new AssertionError();
            if (minMaxAverage(new int[]{99, 38, 20, 49, 89, 16}) != 65.5) throw new AssertionError();
            if (minMaxAverage(new int[]{58, 39, 83, 98, 19, 49, 79, 72, 44}) != 68.0) throw new AssertionError();
            if (minMaxAverage(new int[]{36, 64, 60, 1, 78, 33, 70}) != 40.0) throw new AssertionError();
            if (minMaxAverage(new int[]{21}) != 31.5) throw new AssertionError();
            if (minMaxAverage(new int[]{70, 26, 72, 56, 63, 65}) != 62.0) throw new AssertionError();
            if (minMaxAverage(new int[]{70, 78, 6}) != 45.0) throw new AssertionError();
            if (minMaxAverage(new int[]{15, 71, 37, 43, 33, 61, 79}) != 54.5) throw new AssertionError();
            if (minMaxAverage(new int[]{68, 82, 33}) != 74.0) throw new AssertionError();
            if (minMaxAverage(new int[]{38, 100, 8, 12, 51, 62, 92, 97, 81, 88, 9, 82, 17, 88}) != 58.0) throw new AssertionError();
            if (minMaxAverage(new int[]{59, 64, 32, 76, 69, 53, 78, 1, 59, 82, 14, 35}) != 42.0) throw new AssertionError();
            if (minMaxAverage(new int[]{97, 54, 86, 81, 86, 49, 61, 91}) != 97.5) throw new AssertionError();
            if (minMaxAverage(new int[]{89, 91, 71}) != 116.5) throw new AssertionError();
            if (minMaxAverage(new int[]{89, 35, 56, 76, 11, 5, 35, 6, 11, 49, 65, 38, 43, 32, 60, 4, 71, 67, 80}) != 48.5) throw new AssertionError();
            if (minMaxAverage(new int[]{49, 18, 89, 41, 80, 32}) != 62.5) throw new AssertionError();
            if (minMaxAverage(new int[]{1, 17, 18, 4, 50, 57, 75, 36, 13, 84, 7, 5, 6, 17, 85, 72, 6, 85}) != 43.5) throw new AssertionError();
            if (minMaxAverage(new int[]{51, 3, 96, 10, 42, 84, 7, 96, 24, 51, 38, 65, 54}) != 51.0) throw new AssertionError();
            if (minMaxAverage(new int[]{3, 27, 5, 53, 42, 14, 91, 37, 51, 41, 24, 53, 39, 6, 38, 30, 49}) != 48.5) throw new AssertionError();
            if (minMaxAverage(new int[]{37, 31, 29, 89}) != 73.5) throw new AssertionError();
            if (minMaxAverage(new int[]{60, 1, 6, 23}) != 31.0) throw new AssertionError();
            if (minMaxAverage(new int[]{4, 64, 64, 63, 9, 95, 70, 62, 39, 23, 92, 45, 72, 18, 99, 20}) != 53.5) throw new AssertionError();
            if (minMaxAverage(new int[]{10, 6, 75, 26, 45, 66, 97, 53, 78, 13, 48, 83}) != 54.5) throw new AssertionError();
            if (minMaxAverage(new int[]{64}) != 96.0) throw new AssertionError();
            if (minMaxAverage(new int[]{40, 88, 96, 40, 8}) != 56.0) throw new AssertionError();
            if (minMaxAverage(new int[]{23, 50, 18, 29, 72, 93, 94, 23, 67, 66, 42, 60, 5, 78, 67, 1, 100}) != 51.0) throw new AssertionError();
            if (minMaxAverage(new int[]{68, 94, 79, 20, 63, 91, 4, 4, 7, 31, 81, 32, 19, 40, 90, 7, 3, 58, 85, 27}) != 50.0) throw new AssertionError();
            if (minMaxAverage(new int[]{40, 18, 29, 20, 78, 81, 68, 55, 63, 18, 97, 79, 9, 32, 99}) != 58.5) throw new AssertionError();
            if (minMaxAverage(new int[]{87, 12, 51, 64, 16}) != 55.5) throw new AssertionError();
            if (minMaxAverage(new int[]{4, 67, 68, 46, 47, 65, 93, 36, 49, 54, 50, 57}) != 50.5) throw new AssertionError();
            if (minMaxAverage(new int[]{32, 76, 81, 54}) != 72.5) throw new AssertionError();
            if (minMaxAverage(new int[]{16}) != 24.0) throw new AssertionError();
            if (minMaxAverage(new int[]{14, 98, 69, 73, 21, 28, 71, 73, 11, 52, 8, 82, 59, 81, 54, 19}) != 57.0) throw new AssertionError();
            if (minMaxAverage(new int[]{59, 46, 3, 14, 33, 100, 47, 36, 85, 81, 10, 28, 46, 43, 65, 24}) != 53.0) throw new AssertionError();
            if (minMaxAverage(new int[]{51, 59, 86, 15, 80, 73, 53, 17, 96, 90, 17, 26, 19, 56, 58, 37, 35, 62, 98, 50}) != 64.0) throw new AssertionError();
            if (minMaxAverage(new int[]{42, 34, 55, 94, 98, 99, 33, 95, 47, 45, 24, 2, 89, 1}) != 50.5) throw new AssertionError();
            if (minMaxAverage(new int[]{16, 95, 58, 28, 17, 83, 27, 88, 99, 23, 68, 76, 42, 56, 38, 11, 29, 69, 36, 55}) != 60.5) throw new AssertionError();
            if (minMaxAverage(new int[]{45, 60, 75, 48, 26, 4, 39, 81, 58, 35}) != 44.5) throw new AssertionError();
            if (minMaxAverage(new int[]{94, 66, 87, 45, 20, 20, 83, 96}) != 68.0) throw new AssertionError();
            if (minMaxAverage(new int[]{45, 59, 46, 72, 54}) != 81.0) throw new AssertionError();
            if (minMaxAverage(new int[]{69, 78, 48}) != 87.0) throw new AssertionError();
            if (minMaxAverage(new int[]{57, 88, 20, 50, 36, 35, 41, 57, 2, 52, 23, 86, 87, 87, 69, 33, 12}) != 46.0) throw new AssertionError();
            if (minMaxAverage(new int[]{20, 5, 35, 18, 54, 45, 98, 35, 82, 12, 50, 20, 52, 42, 14}) != 54.0) throw new AssertionError();
            if (minMaxAverage(new int[]{70, 22, 51, 46, 37, 95, 91, 38}) != 69.5) throw new AssertionError();
            if (minMaxAverage(new int[]{47, 4, 23, 17, 45, 19, 32, 86, 3, 56, 27}) != 46.0) throw new AssertionError();
            if (minMaxAverage(new int[]{87, 89, 1, 78, 94, 17, 17}) != 48.0) throw new AssertionError();
            if (minMaxAverage(new int[]{1, 95, 80, 77, 25, 91, 43, 65, 83, 31, 57, 48, 17, 29, 76}) != 48.5) throw new AssertionError();
            if (minMaxAverage(new int[]{73, 72, 22, 94, 44, 63, 54, 34, 38, 31, 36, 19, 33, 22, 82, 50, 88, 47, 49, 33}) != 66.0) throw new AssertionError();
            if (minMaxAverage(new int[]{31, 92, 86, 75, 91, 52, 99, 9, 100, 43, 31, 45, 12, 48, 1, 7, 99, 61, 86, 12}) != 51.0) throw new AssertionError();
            if (minMaxAverage(new int[]{79, 88, 83, 10, 18, 47, 51, 35, 88, 19, 63, 82, 25, 98, 57, 64, 77, 94, 33}) != 59.0) throw new AssertionError();
            if (minMaxAverage(new int[]{4}) != 6.0) throw new AssertionError();
            if (minMaxAverage(new int[]{53, 44, 80, 8, 33, 82, 24, 40, 52, 69, 65, 12}) != 49.0) throw new AssertionError();
            if (minMaxAverage(new int[]{76, 16, 73, 10, 43, 56, 56, 24, 23, 18, 58, 98}) != 59.0) throw new AssertionError();
            if (minMaxAverage(new int[]{29, 29, 20, 69, 42, 55, 68, 47, 92, 33, 32, 52, 63, 85, 92, 46, 84, 72}) != 66.0) throw new AssertionError();
            if (minMaxAverage(new int[]{50, 58, 35, 26, 93, 60, 24, 63, 50, 53}) != 70.5) throw new AssertionError();
            if (minMaxAverage(new int[]{87, 33, 86, 35, 3, 69, 59, 75}) != 46.5) throw new AssertionError();
            if (minMaxAverage(new int[]{97, 37, 31, 15, 82, 14, 56, 3, 75, 19, 25, 25, 18, 94, 82, 54, 36, 55, 81, 94}) != 51.5) throw new AssertionError();
            if (minMaxAverage(new int[]{70, 33, 78, 75, 65, 48, 75, 22, 57, 79, 61, 75, 54}) != 61.5) throw new AssertionError();
            if (minMaxAverage(new int[]{9, 98, 92, 45, 59, 78, 32, 8, 96, 44, 23, 62, 34, 91, 93, 99, 86, 45}) != 57.5) throw new AssertionError();
            if (minMaxAverage(new int[]{89, 42, 37, 21, 89, 7, 47, 29, 49, 32, 74, 43, 3}) != 47.5) throw new AssertionError();
            if (minMaxAverage(new int[]{52, 59, 20}) != 49.5) throw new AssertionError();
            if (minMaxAverage(new int[]{58, 54, 60, 61, 7, 6, 40, 17, 1, 70}) != 36.0) throw new AssertionError();
            if (minMaxAverage(new int[]{44, 58, 33, 78, 67, 84}) != 75.0) throw new AssertionError();
            if (minMaxAverage(new int[]{89, 96, 59, 93, 73, 68, 9, 92, 5, 12, 16, 83, 94}) != 53.0) throw new AssertionError();
            if (minMaxAverage(new int[]{41, 67, 64, 66, 42, 41, 58, 28, 68, 38, 95, 4, 30, 87, 77, 93, 11, 66, 75}) != 51.5) throw new AssertionError();
            if (minMaxAverage(new int[]{26, 98, 58, 33, 48, 55, 92, 57, 3, 26, 83, 85, 43, 65, 47, 83, 36, 2, 65}) != 51.0) throw new AssertionError();
            if (minMaxAverage(new int[]{88, 31, 32, 25, 16, 87, 14}) != 58.0) throw new AssertionError();
            if (minMaxAverage(new int[]{27, 80, 87, 3, 67, 27, 76, 82, 7}) != 46.5) throw new AssertionError();
            if (minMaxAverage(new int[]{68, 71, 58, 43, 9, 100, 100, 90, 33, 39, 72, 76}) != 59.0) throw new AssertionError();
            if (minMaxAverage(new int[]{56, 49, 89, 3, 24, 51, 12, 98, 51, 79, 26, 86, 38, 89, 36, 18}) != 52.0) throw new AssertionError();
            if (minMaxAverage(new int[]{32, 44, 44, 62, 51, 35, 67, 46, 19, 72}) != 55.0) throw new AssertionError();
            if (minMaxAverage(new int[]{12, 12, 60, 55, 95, 35, 40, 57}) != 59.5) throw new AssertionError();
            if (minMaxAverage(new int[]{9, 39, 30, 25, 85, 44, 91, 63, 73, 91, 1, 81, 54, 86, 4, 79, 35, 97}) != 49.5) throw new AssertionError();
            if (minMaxAverage(new int[]{45, 3, 49, 52, 87, 85, 11, 22, 46, 63, 37, 79, 99, 34, 67}) != 52.5) throw new AssertionError();
            if (minMaxAverage(new int[]{4, 32, 82, 30, 51, 97, 4, 91, 86, 65, 15}) != 52.5) throw new AssertionError();
            if (minMaxAverage(new int[]{22, 59, 56, 44, 39, 33, 46, 22, 7, 99}) != 56.5) throw new AssertionError();
            if (minMaxAverage(new int[]{84, 17, 82, 65, 25, 84, 73, 53, 3, 24, 59, 89, 11, 29, 46, 26, 85, 9, 72, 42}) != 47.5) throw new AssertionError();
            if (minMaxAverage(new int[]{47}) != 70.5) throw new AssertionError();
            if (minMaxAverage(new int[]{66, 36, 54, 87, 82, 19, 96, 55, 77, 48, 10, 58, 34, 64, 70, 39, 28, 97, 22, 2}) != 50.5) throw new AssertionError();
            if (minMaxAverage(new int[]{23, 39, 32}) != 42.5) throw new AssertionError();
            if (minMaxAverage(new int[]{97, 41, 25, 80, 98, 51, 70, 56, 85, 34, 74, 35}) != 74.0) throw new AssertionError();
            if (minMaxAverage(new int[]{87, 79, 91, 85, 14, 23, 7, 5, 32, 78, 27, 18}) != 50.5) throw new AssertionError();
            if (minMaxAverage(new int[]{32, 62, 29, 71, 50, 63, 40, 68, 94, 44, 6, 52, 89, 50, 89, 90, 57, 32, 33}) != 53.0) throw new AssertionError();
            if (minMaxAverage(new int[]{18, 29, 3, 11, 79, 32, 18, 85, 28, 51, 61, 76, 91, 87}) != 48.5) throw new AssertionError();
            if (minMaxAverage(new int[]{16, 35, 99, 56, 46, 57, 28, 52, 98, 44, 63, 61, 3}) != 52.5) throw new AssertionError();
            if (minMaxAverage(new int[]{15, 86, 61, 70}) != 58.0) throw new AssertionError();
            if (minMaxAverage(new int[]{38, 17, 62, 20, 73, 35, 12, 35, 74, 92}) != 58.0) throw new AssertionError();
            if (minMaxAverage(new int[]{77, 41, 56, 84, 6, 94, 53, 46}) != 53.0) throw new AssertionError();
            if (minMaxAverage(new int[]{41, 38, 90, 14, 91, 99, 87, 7, 82, 49, 39, 42, 82, 41, 39, 54, 63, 55}) != 56.5) throw new AssertionError();
            if (minMaxAverage(new int[]{52, 26, 51, 97, 96, 54, 6, 73, 62, 93, 10, 6, 31, 86, 74, 9, 73, 33, 22}) != 54.5) throw new AssertionError();
            if (minMaxAverage(new int[]{55, 7, 12, 63, 82}) != 48.0) throw new AssertionError();
            if (minMaxAverage(new int[]{69, 74, 57, 33, 15, 73, 59, 76, 38, 75, 63, 17, 5, 95, 46, 77}) != 52.5) throw new AssertionError();
            if (minMaxAverage(new int[]{3, 39, 84, 52, 46, 7, 4, 18, 49, 73, 33, 46}) != 45.0) throw new AssertionError();
            if (minMaxAverage(new int[]{2, 75, 5, 64, 8, 83, 87, 98, 81, 62, 74, 25}) != 51.0) throw new AssertionError();
            if (minMaxAverage(new int[]{53, 18}) != 44.5) throw new AssertionError();
            if (minMaxAverage(new int[]{34, 81, 45}) != 74.5) throw new AssertionError();
            if (minMaxAverage(new int[]{19}) != 28.5) throw new AssertionError();
            if (minMaxAverage(new int[]{67}) != 100.5) throw new AssertionError();
            if (minMaxAverage(new int[]{48, 78, 86, 31, 97, 29}) != 77.5) throw new AssertionError();
        }



    }
}
