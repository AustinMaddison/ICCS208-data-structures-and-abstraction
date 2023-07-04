//package Lecture15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Lecture15 {

    static <T> void insertionSort(T[] array, Comparator<T> cc) {
        int i = 0; // current index of concern
        int k = 0; // key
        while (i < array.length - 1) {
            while (true) {

                // if sorted
                if (0 < cc.compare(array[k], array[k + 1]))
                    break;

                    // else swap
                else {
                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    if (k > 1) k--;
                }
            }
            i++;
            k = i;
        }
    }

    private static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    static <T> void quickSort(T[] array, int lowIndex, int highIndex, Comparator<T> cc) {
        if (lowIndex >= highIndex) {
            return;
        }

        // choose random pivot
        int pivotPtr = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        T pivot = array[pivotPtr];

        int leftPtr = lowIndex;
        int rightPtr = highIndex;

        // partitioning
        while (leftPtr < rightPtr) {
            while (cc.compare(array[leftPtr], pivot) <= 0 && leftPtr < rightPtr) {
                leftPtr++;
            }

            while (cc.compare(array[rightPtr], pivot) >= 0 && leftPtr < rightPtr) {
                rightPtr--;
            }

            swap(array, leftPtr, rightPtr);
        }

        swap(array, leftPtr, pivotPtr);

        quickSort(array, lowIndex, leftPtr - 1, cc);
        quickSort(array, leftPtr + 1, highIndex, cc);
    }

    static <T> void quickSort(T[] array, Comparator<T> cc) {
        quickSort(array, 0, array.length - 1, cc);
    }


    static <T> void mergeSort(T[] array, Comparator<T> cc) {
        if (array.length <= 1) return;

        int midpoint = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, midpoint);
        T[] right = Arrays.copyOfRange(array, midpoint, array.length);

        mergeSort(left, cc);
        mergeSort(right, cc);

        merge(array, left, right, cc);
    }

    static <T> void merge(T[] array, T[] left, T[] right, Comparator<T> cc) {
        int i = 0, j = 0;
        while (i + j < array.length) {
            if (j == right.length || (i < left.length && cc.compare(left[i], right[j]) < 0))
                array[i + j] = left[i++];
            else
                array[i + j] = right[j++];
        }
    }


//    public static void main(String[] args) {
//
//        Comparator<Integer> cc = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        };
//
//
//        Integer[] a = {12, 4, 22, 0, 1};
////        insertionSort(a, cc);
//        mergeSort(a, cc);
//
//        System.out.println(Arrays.toString(a));
//    }
}
