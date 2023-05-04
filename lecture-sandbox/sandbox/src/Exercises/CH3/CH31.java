package Exercises.CH3;

import java.util.Arrays;
public class CH31 {
    public static void main(String[] args) {
        /* 3.1 */
        int size = 5;
        int a = 12, b = 5, n = 100, cur = 92;
        int[] pseudorandom_num_arr = new int[5];
        for(int index = 0; index < size; index++){
            cur = (a * cur + b) % n;
            pseudorandom_num_arr[index] = cur;
        }

        System.out.println(Arrays.toString(pseudorandom_num_arr));

    }

}
