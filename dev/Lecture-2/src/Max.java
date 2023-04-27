public class Max {

    /**
     * @param arr array of numbers.
     * @return max value from the array.
     */
    public static int maxWhile(int[] arr ) {
        int idx = 1;
        int max = arr[0];
        while (idx < arr.length){
            if(arr[idx] > max)
                max = arr[idx];
            idx++;
        }
        return max;
    }

    /**
     * @param arr array of numbers.
     * @return max value from the array.
     */
    public static int maxFor(int[] arr) {
        int max = arr[0];
        for(int num: arr) {
            if(num > max)
                max = num;
        }
        return max;
    }
}
