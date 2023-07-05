
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Uproot {
    public static Map<Integer, Integer> treeToParentMap(BinaryTreeNode T) {
        Map<Integer, Integer> map = new HashMap<>();
        treeToParentMapHelper(map, T);
        return  map;
    }

    private static void treeToParentMapHelper(Map<Integer, Integer> map, BinaryTreeNode parent) {
        if(parent == null)
            return;

        treeToParentMapHelper(map, parent.left);
        treeToParentMapHelper(map, parent.right);

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


}
