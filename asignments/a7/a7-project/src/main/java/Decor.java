import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decor {


    public static BinaryTreeNode mkTree(List<Integer> postOrder, List<Integer> inOrder) {

        // Create root.
        Integer rootKey = postOrder.get(postOrder.size() - 1);
        int inOrderRootIdx = inOrder.indexOf(rootKey);
        BinaryTreeNode root = new BinaryTreeNode(null, rootKey, null);

        // Grow tree.
        mkTreeHelper(root, postOrder.size() - 1, inOrderRootIdx, postOrder, inOrder);

        return root;
    }

    private static void mkTreeHelper(BinaryTreeNode parent,
                                     int postOrderParentIdx, int inOrderParentIdx,
                                     List<Integer> postOrder, List<Integer> inOrder) {
        if (parent == null)
            return;

        // Split the lists using last parent positions.
        // Post-order:
        List<Integer> leftPostOrder = new ArrayList<>();
        List<Integer> rightPostOrder = new ArrayList<>();

        for (int i = 0; i < inOrderParentIdx; i++)
            leftPostOrder.add(postOrder.get(i));
        for (int i = inOrderParentIdx; i < postOrderParentIdx; i++)
            rightPostOrder.add(postOrder.get(i));

        // In-order:
        List<Integer> leftInOrder = new ArrayList<>();
        List<Integer> rightInOrder = new ArrayList<>();

        for (int i = 0; i < inOrderParentIdx; i++)
            leftInOrder.add(inOrder.get(i));
        for (int i = inOrderParentIdx + 1; i < inOrder.size(); i++)
            rightInOrder.add(inOrder.get(i));


        // Add children to last parent.
        if (leftPostOrder.size() > 0) {
            int leftChildPostOrderIdx = leftPostOrder.size() - 1;
            int leftChildKey = leftPostOrder.get(leftChildPostOrderIdx);
            int leftChildInOrderIdx = leftInOrder.indexOf(leftChildKey);

            parent.left = new BinaryTreeNode(leftChildKey);   
            mkTreeHelper(parent.left, leftChildPostOrderIdx, leftChildInOrderIdx, leftPostOrder, leftInOrder);
        }
        if (rightPostOrder.size() > 0) {
            int rightChildPostOrderIdx = rightPostOrder.size() - 1;
            int rightChildKey = rightPostOrder.get(rightChildPostOrderIdx);
            int rightChildInOrderIdx = rightInOrder.indexOf(rightChildKey);

            parent.right = new BinaryTreeNode(rightChildKey);
            mkTreeHelper(parent.right, rightChildPostOrderIdx, rightChildInOrderIdx, rightPostOrder, rightInOrder);
        }
    }
}
