import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UprootTest {

    @Test
    public void testMapToTree(){
        // Test map to tree.
        System.out.println("Map to tree test:");
        Map<Integer, Integer> p = new HashMap<>();
        p.put(20, 1);
        p.put(9, 1);
        p.put(14, 20);
        p.put(2, 9);
        p.put(18, 9);

        for(Integer key: p.keySet())
            System.out.println(String.format("(%d, %d)", key, p.get(key)));
        BinaryTreeNode a = Uproot.parentMapToTree(p);

        System.out.println(Helpers.Debug.display(a, Helpers.Debug.TreeOrder.POSTORDER));
        System.out.println();


    }

    @Test
    public  void testTreeToMap() {
        System.out.println("Tree to map test:");
        Map<Integer, Integer> p = new HashMap<>();
        p.put(20, 1);
        p.put(9, 1);
        p.put(14, 20);
        p.put(2, 9);
        p.put(18, 9);

        BinaryTreeNode a = Uproot.parentMapToTree(p);

        // Test tree to map.
        System.out.println("Tree to map:");
        System.out.println(Helpers.Debug.display(a, Helpers.Debug.TreeOrder.POSTORDER));
        p = Uproot.treeToParentMap(a);
        for(Integer key: p.keySet())
            System.out.println(String.format("(%d, %d)", key, p.get(key)));
    }


    @Test
    public  void testTreeToMapLingLing() {
        LinkedList<Integer> poo = new LinkedList<>();
        poo.addAll(List.of(2, 4, 5, 12, 10, 7));

        LinkedList<Integer> inor = new LinkedList<>(List.of(2, 4, 5, 7, 10, 12));

        BinaryTreeNode preoNinor = Decor.mkTree(poo,inor);

        System.out.print("Preorder for pronuarr: ");
        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.PREORDER));

        System.out.print("Expected Preorder: 7, 5, 4, 2, 10, 12\n");
        System.out.print("Inorder: ");
        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.INORDER));
        System.out.print("Expected Inorder:2, 4, 5, 7, 10, 12\n");
        System.out.print("Postorder: ");
        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.POSTORDER));
        System.out.print("Expected Post: 2, 4, 5, 12, 10, 7\n");
    }










    @Test
    public void testElapsedTime() {
        long startTime = System.currentTimeMillis();

        System.out.println("Max 2 seconds execution time");
        System.out.println("=============================");
        int n = 2000;

        // Test map to tree.
//        System.out.println("Map to tree test:");
        Map<Integer, Integer> p = new HashMap<>();
        for(int i = 0; i < n-1; i++)
            p.put(i, i+1);


//        for(Integer key: p.keySet())
//            System.out.println(String.format("(%d, %d)", key, p.get(key)));
        BinaryTreeNode a = Uproot.parentMapToTree(p);
//
//        System.out.print("Post-order: ");
//        System.out.println(Decor.Debug.display(a, Decor.Debug.TreeOrder.POSTORDER));
//        System.out.println();

//        // Test tree to map.
//        System.out.println("Tree to map test:");
//
//        System.out.print("Post-order: ");
//        System.out.println(Decor.Debug.display(a, Decor.Debug.TreeOrder.POSTORDER));
        p = Uproot.treeToParentMap(a);
//        for(Integer key: p.keySet())
//            System.out.println(String.format("(%d, %d)", key, p.get(key)));

        long endTime = System.currentTimeMillis();
        float duration = (endTime - startTime) / 1000F;  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " seconds.");
    }
}