import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Uproot {
    public static Map<Integer, Integer> treeToParentMap(BinaryTreeNode T) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(map, T);
        return  map;
    }

    private static void helper(Map<Integer, Integer> map, BinaryTreeNode parent) {
        if(parent == null) return;


        helper(map, parent.left);
        helper(map, parent.right);

        if(parent.left != null)
            map.put(parent.left.key, parent.key);
        if(parent.right != null)
            map.put(parent.right.key, parent.key);
    }

    public static BinaryTreeNode parentMapToTree(Map<Integer, Integer> map) {

        Map<Integer, BinaryTreeNode> nodeMap = new HashMap<>();

        // Used to compute the root of the tree parents - children = root
        Set<Integer> computeRoot = new HashSet<>();

        // Create all parents in the tree.
        for (Integer parent : map.values()) {
            computeRoot.add(parent);
            nodeMap.put(parent, new BinaryTreeNode(parent));
        }

        // Connects parents with children.
        for (Integer child : map.keySet()) {
            computeRoot.remove(child); // remove all children leaving root

            boolean isLeaf = !(nodeMap.containsKey(child));
            BinaryTreeNode parentNode = nodeMap.get(map.get(child));

            if (parentNode.left == null)
                parentNode.left = isLeaf ? new BinaryTreeNode(null, child, null) : nodeMap.get(child);
            else
                parentNode.right = isLeaf ? new BinaryTreeNode(null, child, null) : nodeMap.get(child);
        }

        return nodeMap.get(computeRoot.toArray()[0]);
    }


    public static void main(String[] args) {

        System.out.println("DEBUG ");
        System.out.println("======================= ");

        // Test map to tree.
        System.out.println("Map to tree:");
        Map<Integer, Integer> p = new HashMap<>();
        p.put(20, 1);
        p.put(9, 1);
        p.put(14, 20);
        p.put(2, 9);
        p.put(18, 9);

        for(Integer key: p.keySet())
            System.out.println(String.format("(%d, %d)", key, p.get(key)));
        BinaryTreeNode a = parentMapToTree(p);

        System.out.println(MakeTree.display(a));
        System.out.println();

        // Test tree to map.
        System.out.println("Tree to map:");
        System.out.println(MakeTree.display(a));
        p = treeToParentMap(a);
        for(Integer key: p.keySet())
            System.out.println(String.format("(%d, %d)", key, p.get(key)));

    }

}
