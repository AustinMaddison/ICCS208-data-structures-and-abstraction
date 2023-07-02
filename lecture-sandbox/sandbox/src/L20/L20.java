//package L20;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class L20 {
//
//    interface UndirectedGraph<Vertex> {
//        Iterable<Vertex> adj(Vertex v);
//    }
//
//
//
//    public Set<Integer> nbrs(
//            UndirectedGraph<Integer> G,
//            Set<Integer> F ) {
//
//        Set<Integer> nbrSet = new HashSet<>();
//        for(Integer u: F) {
//            for{Set<Integer> v: G.adj(u)} {
//                nbrSet.add(v);
//            }
//
//        }
//
//
//
//
//        }
//    }
//
//
//
//
//    public Set<Integer> bfs(
//            UndirectedGraph<Integer> G,
//            Integer s ) {
//        Set<Integer> frontier = new HashSet<>(List.of(s));
//        Set<Integer> seen = new HashSet<>(List.of(s));
//
//        while(!frontier.isEmpty()) {
//
//            frontier = nbrs(G, frontier);
//            frontier = removeAll(G, frontier);
//        }
//
//
//    }
//
//}
