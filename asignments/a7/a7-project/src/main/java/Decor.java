import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Decor {


    public static BinaryTreeNode mkTree(List<Integer> postOrder, List<Integer> inOrder) {


        // map inorder key to index
        HashMap<Integer, Integer> IoKeyToIdxMap = new HashMap<>();
        for(int i = 0; i < inOrder.size(); i++)
            IoKeyToIdxMap.put(inOrder.get(i), i);

        // Create root.
        Integer rootKey = postOrder.get(postOrder.size() - 1);
        int IoRootIdx = IoKeyToIdxMap.get(rootKey);
        BinaryTreeNode root = new BinaryTreeNode(null, rootKey, null);

        // Grow tree.
        mkTreeHelper(root, postOrder.size() - 1, IoRootIdx, postOrder, inOrder, IoKeyToIdxMap, 0, 0, postOrder.size());

        return root;
    }

    private static void mkTreeHelper(BinaryTreeNode parent,
                                     int PoParentIdx, int IoParentIdx,
                                     List<Integer> PoLst, List<Integer> IoLst, HashMap<Integer, Integer> IoKeyToIdxMap,
                                     int PoStart, int IoStart, int size) {
        if (parent == null || size == 1)
            return;

        // Calculate pointers for left and right subtrees


        int sizeLeft = IoParentIdx - IoStart;
        int sizeRight = size - sizeLeft - 1;

        int IoStartLeft = IoStart;
        int IoStartRight = PoStart+sizeLeft;

        int PoStartLeft = PoStart;
        int PoStartRight = IoParentIdx+1 ;


        // Add children to last parent.
        if (sizeLeft > 0) {
            int leftChildPoIdx = PoStartLeft + sizeLeft - 1;
            int leftChildKey = PoLst.get(leftChildPoIdx);
            int leftChildIoIdx = IoKeyToIdxMap.get(leftChildKey);

            parent.left = new BinaryTreeNode(leftChildKey);
            mkTreeHelper(parent.left, leftChildPoIdx, leftChildIoIdx, PoLst, IoLst, IoKeyToIdxMap, PoStartLeft, IoStartLeft, sizeLeft);
        }
        if (sizeRight > 0) {
            int rightChildPoIdx = PoStartRight + sizeRight - 1;
            int rightChildKey = PoLst.get(rightChildPoIdx);
            int rightChildIoIdx = IoKeyToIdxMap.get(rightChildKey);

            parent.right = new BinaryTreeNode(rightChildKey);
            mkTreeHelper(parent.right, rightChildPoIdx, rightChildIoIdx, PoLst, IoLst, IoKeyToIdxMap, PoStartRight, IoStartRight, sizeRight);
        }

    }
}
