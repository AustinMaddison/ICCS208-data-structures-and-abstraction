package KFact;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<Integer> kFactorization(int n, List<Integer> A) {
        int target = n;

        Comparator<Integer> min = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        };

        Comparator<Integer> max = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        PriorityQueue<Integer> facQ = new PriorityQueue<>(min);
        PriorityQueue<Integer> divFacQ = new PriorityQueue<>(max);

        facQ.addAll(A);

        while (!facQ.isEmpty()) {
            // retrieve divisible numbers which are the factors.
            if(target % facQ.peek() == 0) {
                target /= facQ.peek();
                divFacQ.add(facQ.peek());
            }
            else {
               facQ.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        if(target != 1) {
            result.add(-1);
            return result;
        }
        else {
            divFacQ.add(1);
            while (!divFacQ.isEmpty()){
                target *= divFacQ.poll();
                result.add(target);
            }
            return result;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.kFactorization(n, A);

//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining(" "))
//                        + "\n"
//        );

        bufferedReader.close();
        for(int i : result)
            System.out.print(i + " ");

//        bufferedWriter.close();
    }
}