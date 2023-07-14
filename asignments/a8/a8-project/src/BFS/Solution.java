package BFS;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Result {

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {

        List<Set<Integer>> adjacentMap = new ArrayList<>();

        Set<Integer> visited = new HashSet<>(), prevFrontier = new HashSet<>();
        int edgeCost = 6, unreachableCost = -1;

        for (int i = 0; i < n + 1; i++)
            adjacentMap.add(new HashSet<>());
        for (List<Integer> e : edges) {
            int u = e.get(0), v = e.get(1);
            adjacentMap.get(u).add(v);
            adjacentMap.get(v).add(u);
        }

        int[] costs = new int[n];
        // Reachable vertices costs.
        Deque<Integer> frontier = new ArrayDeque<>();
        frontier.add(s);
        int iter = 0;
        while (!frontier.isEmpty()) {
            int k = frontier.size();
            for (int i = 0; i < k; i++) {
                int v = frontier.pop();

                if (!visited.contains(v)) {
                    visited.add(v);
                    frontier.addAll(adjacentMap.get(v));

                    if (iter > 0) {
                        costs[v - 1] = iter * edgeCost;
                    }
                }
            }
            iter++;
        }

        // Unreachable nodes costs
        for (int i = 1; i < adjacentMap.size(); i++) {
            if (adjacentMap.get(i).size() == 0)
                costs[i - 1] = unreachableCost;
        }

        List<Integer> finalCost = new ArrayList<>();
        for (int c : costs)
            if (c != 0) finalCost.add(c);

        for (int c : finalCost)
            System.out.println(c);
        return finalCost;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        Result.bfs(4, 2, List.of(List.of(1, 2), List.of(1, 3)), 1);
        Result.bfs(3, 1, List.of(List.of(2, 3)), 2);
        Result.bfs(6, 2, List.of(List.of(2, 3), List.of(4, 5)), 5);
    }


}

