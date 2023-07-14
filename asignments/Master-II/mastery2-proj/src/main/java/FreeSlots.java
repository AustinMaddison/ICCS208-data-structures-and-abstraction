import java.util.*;

public class FreeSlots {

    public static List<String> topFreeSlots(
            int n,
            List<List<Integer>> occupied,
            int topK) {

        // Initialize counting O(n)
        Integer[][] count = new Integer[n][2];
        for(int time = 0; time<n; time++){
            count[time] = new Integer[]{time, occupied.size()} ;
        }

        // Deduct counts O(m)
        for(List<Integer> slotLst: occupied){
            for(Integer slot: slotLst)
                count[slot][1]--;
        }

        // Sort by available kittens
        Arrays.sort(count,
                (a, b) -> Integer.compare(b[1],a[1])); // log(n)

        List<String> result = new ArrayList<>(); // O(topK)
        for (int i = 0; i < topK; i++){
            result.add(count[i][0]+"_"+count[i][1]);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> occupied = List.of(
            List.of(3, 1, 2, 5),
            List.of(1, 0, 5),
            List.of(1, 2),
            List.of(2, 5)
        );
        List<String> top = topFreeSlots(6, occupied, 3);
        System.out.println(top);
    }
}
