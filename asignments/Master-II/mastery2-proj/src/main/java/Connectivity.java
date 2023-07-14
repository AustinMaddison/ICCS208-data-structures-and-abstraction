import java.util.*;

public class Connectivity {
    // for a limited buget, try to have as few components as possible
    // when the planning is over,
    // return # of islands that remain isolated
    public static int optimize(int numIslands, int[][] cablingCost, int budget) {

        Set<Integer> visited = new HashSet<>();
        HashMap<Integer, Set<Integer>> neibours = new HashMap<>();
        HashMap<Set<Integer>, Integer> edgeCosts = new HashMap<>();
        HashMap<Integer, Set<Integer>> costToEdge = new HashMap<>();

        int min = Integer.MAX_VALUE;
        for(int[] edge : cablingCost) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if(cost < min)
                min = cost;

            neibours.getOrDefault(u, new HashSet<>(v)).add(v);
            neibours.getOrDefault(v, new HashSet<>(u)).add(u);
            edgeCosts.put(new HashSet<>(u,v), cost);
            costToEdge.put(cost, new HashSet<>(u,v));
        }

        Queue<Integer> queue = new PriorityQueue<>();
        queue.addAll(costToEdge.get(min));

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int neighbour : neibours.get(current) ) {
                if(!visited.contains(neighbour)) {
                    Set<Integer> s = new HashSet<>();
                    s.add(current);
                    s.add(neighbour);
                    if(budget-edgeCosts.get(s) < );
                }

            }

        }


        int cost =

        return -1;
    }

    public static void main(String[] args) {

        int[][] cablings = {
                {0, 2, 19},
                {1, 0, 25},
                {3, 1, 10},
                {3, 4, 9},
                {2, 4, 12},
                {1, 2, 2},
                {4, 1, 7}
        };
        System.out.println(optimize(
                5,
                cablings,
                9
        )); // expect: 2

      /* another example:
       int[][] cablings = {
           {0, 1, 3},
           {1, 2, 2}
       };
       System.out.println(optimize(
               3,
               cablings,
               1
       ));
    */
    }
}
