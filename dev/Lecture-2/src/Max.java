public class Max {

    /**
     * Computes and return the max of an array.
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
     * Computes and return the max of an array.
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

    /**
     * Computes and return the max of an array.
     * @param arr array of numbers.
     * @return max value from the array.
     */
    public static int maxCStyleFor(int[] arr) {
        int max = arr[0];
        for(int idx = 1; idx < arr.length; idx++) {
            if(arr[idx] > max)
                max = arr[idx];
        }
        return max;
    }
}
