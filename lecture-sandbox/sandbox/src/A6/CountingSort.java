package A6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class CountingSort {


    public static int toInt(String s) {
        if(Objects.equals(s, "")) return -1;

        return Integer.parseInt(s);
    }

    /* Counting sort details from https://www.programiz.com/dsa/counting-sort */
    public static void countSort(List<List<String>> arr) {
        int n = arr.size();

        // Get max.
        int max = toInt(arr.get(0).get(0));

        for (int i = 1; i < n; i++) {
            int current = toInt(arr.get(i).get(0));
            if (current > max)
                max = current;
        }
        int m = max+1;

        // Create count list of size max + 1.
        int[] count = new int[m];

        // Count numbers
        for (List<String> pairs : arr) {
            int key = toInt(pairs.get(0));
            count[key]++;
        }

        // Cumulative sum
        for (int i = 0; i < m - 1; i++)
            count[i + 1] += count[i];

        List<List<String>> sortedArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> innerList = new ArrayList<String>();
            innerList.add("");
            innerList.add("");
            sortedArr.add(innerList);
        }

        // Sort arr using cumulative sum.
        for (int i = n-1; i >= 0; i--)  {

            List<String> pair = arr.get(i);
            int key = toInt(pair.get(0));
            int idx = count[key] - 1;          // position of number in sorted array.


            List<String> newPair = new ArrayList<String>();
            newPair.add( pair.get(0));
            newPair.add(i < n/2 ? "-" : pair.get(1));

            sortedArr.set(idx, newPair);
            count[key]--;
        }

        // Print sorted list.
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            output.append(sortedArr.get(i).get(1));
            if(i < n-1)
                output.append(" ");
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        List<List<String>> a = List.of(
                List.of("0", "e"),
                List.of("2", "a"),
                List.of("1", "b,"),
                List.of("3", "a"),
                List.of("4", "f"),
                List.of("1", "f"),
                List.of("2", "a"),
                List.of("1", "e"),
                List.of("1", "b"),
                List.of("1", "c")
        );

        countSort(a);
    }

}