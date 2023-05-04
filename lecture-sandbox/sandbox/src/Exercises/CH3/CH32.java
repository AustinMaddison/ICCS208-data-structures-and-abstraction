package Exercises.CH3;

import java.util.Arrays;

public class CH32 {
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

        n= 57;
        while(pseudorandom_num_arr.length != 0) {
            cur = ((a * cur + b) % n) % pseudorandom_num_arr.length;

            int[] temp = new int[pseudorandom_num_arr.length - 1];
            for(int index = 0; index < pseudorandom_num_arr.length-1; index++){
                if(index < cur) {
                    temp[index] = pseudorandom_num_arr[index];
                    continue;
                }
                temp[index] = pseudorandom_num_arr[index+1];
            }

            pseudorandom_num_arr = Arrays.copyOf(temp, temp.length);
            System.out.println(Arrays.toString(pseudorandom_num_arr));

        }


    }

    static void RemoveElement(int[] R, int i) {

    }

}
