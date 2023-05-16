package Lecture7;

import java.util.function.BiFunction;

public class Max <T> {
    int maxIndex(T[] items, BiFunction<T, T, Boolean> isLarger) {
        if(items.length == 0) return -1;
        int currentMaxIdx = 0;
        for(int i = 1; i < items.length; i++) {
            if(isLarger.apply(items[i], items[currentMaxIdx]))
                currentMaxIdx = i;
        }
        return currentMaxIdx;
    }


    public static void main(String[] args) {

    }

}
