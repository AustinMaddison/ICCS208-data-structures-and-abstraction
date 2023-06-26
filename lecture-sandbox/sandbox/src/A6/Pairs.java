package A6;

import java.util.HashMap;
import java.util.List;

public class Pairs {

    public static int pairs(int k, List<Integer> arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>(); // key, count

        for(int number: arr) {
            if(countMap.containsKey(number))
                countMap.put(number, countMap.get(number)+1);
            else
                countMap.put(number, 1);
        }

        int count = 0;
        for(int number: countMap.keySet()) {
            if(countMap.containsKey(number+k)) {
                count += countMap.get(number);
            }
        }

        return count;
    }

}
