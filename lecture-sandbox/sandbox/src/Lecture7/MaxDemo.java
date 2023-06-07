package Lecture7;

import java.util.function.BiFunction;

public class MaxDemo<T> {

    int maxIndex(T[] items, BiFunction<T, T, Boolean> isLarger) {

        // Empty input array.
        if (items.length == 0) {
            return -1;
        }

        int currentMaxIdx = 0;
        for (int i = 1; i < items.length; i++) {
            if (isLarger.apply(items[i], items[currentMaxIdx]))
                currentMaxIdx = i;
        }
        return currentMaxIdx;
    }

    static <T> T maxValue(T[] items, BiFunction<T, T, Boolean> isLarger) {

        // Empty input array.
        if (items.length <= 0) {
            return null;
        }

        T currentMax = items[0];
        for (int idx = 1; idx < items.length; idx++) {
            if (isLarger.apply(items[idx], currentMax)) {
                currentMax = items[idx];
            }
        }

        return currentMax;
    }

    private static class IntIsLarger implements BiFunction<Integer, Integer, Boolean> {

        @Override
        public Boolean apply(Integer t, Integer u) {
            return t > u;
        }

    }

    public static void main(String[] args) {

        MaxDemo<Integer> maxDemo = new MaxDemo<Integer>();

        BiFunction<Integer, Integer, Boolean> compareFunc = new IntIsLarger();
        // int[] l = new int[] { 23, 4, 2123, 12 };
        Integer[] ll = new Integer[] { 23, 4, 2123, 12 };

        int myMax = maxDemo.maxValue(ll, compareFunc);
        System.out.println(myMax);
    }

}
