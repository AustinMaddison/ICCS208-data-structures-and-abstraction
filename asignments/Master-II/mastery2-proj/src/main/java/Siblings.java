import java.util.*;

public class Siblings {
  // add your class variable here
  // e.g. int magic;  and set the value in the constructor

  HashMap<Integer, Integer> cpTree;

  HashMap<Integer, Integer> adjV;
  Integer[] distances;

  public Siblings(HashMap<Integer, Integer> cpTree) {
    this.cpTree = cpTree;
    distances = new Integer[cpTree.size()];
    Arrays.fill(distances, -1);
  }

  public boolean isSibling(int u, int v) {

    // Gets distance and stores in cache.
    if(distances[u] == -1)
      distances[u] = getDepth(u);
    if(distances[v] == -1)
      distances[v] = getDepth(v);

    return distances[u] == distances[v];
  }

  private int getDepth(int u) {
    /* 2*log(n) = O(log(n)) */
    int p = cpTree.get(u);
    if(p == u) return 0;
      else return getDepth(p) + 1;
  }

  public static void main(String[] args) {
    HashMap<Integer, Integer> tr = new HashMap<>();
    Integer[] par   = {4, 4, 4, 4, 3, 3, 8, 8, 8};
    Integer[] nodes = {4, 1, 3, 8, 0, 2, 6, 7, 5};
    for (int i=0;i<par.length;i++) tr.put(nodes[i], par[i]);


    long start = System.currentTimeMillis();


    Siblings sbl = new Siblings(tr);
    for(int i = 0; i < 1000000000; i++){
      sbl.isSibling(2, 5);
      sbl.isSibling(1, 7);
    }

//    System.out.println(sbl.isSibling(2, 5)); // true
//    System.out.println(sbl.isSibling(1, 7)); // false
    long end = System.currentTimeMillis();
    //finding the time difference and converting it into seconds
    float sec = (end - start) / 1000F; System.out.println(sec + " seconds");

  }
  
}
