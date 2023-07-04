import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Uproot {
//    public static HashMap<Integer, Integer> treeToParentMap(BinaryTreeNode T) {
//
//    }

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

        // Test map to tree.
        Map<Integer, Integer> p = new HashMap<>();
        p.put(20, 1);
        p.put(9, 1);
        p.put(14, 20);
        p.put(2, 9);
        p.put(18, 9);
        BinaryTreeNode a = parentMapToTree(p);

        System.out.println(MakeTree.display(a));


    }

}
