import java.util.Arrays;
import java.util.List;

public class Decor {


    public static BinaryTreeNode mkTree(List<Integer> inOrder, List<Integer> preOrder) {

        Integer rootKey = preOrder.get(preOrder.size() - 1);
        int rootPos = inOrder.indexOf(rootKey);

        // Create tree: create root then use helper to do it recursively for subtrees
        BinaryTreeNode root = new BinaryTreeNode(null, rootKey, null);

        // Convert list to array.
        Integer[] keys = new Integer[inOrder.size()];
        for(int i = 0; i < inOrder.size(); i++ )
            keys[i] = inOrder.get(i);


        mkTreeHelper(root, rootPos, keys);

        return root;
    }

    private static void mkTreeHelper(BinaryTreeNode parent, Integer parentPos, Integer[] keys) {
        if(parent == null)
            return;

        // Split the list at the rootPos to process left and right subtrees.
        Integer[] left = Arrays.copyOfRange(keys, 0, parentPos);
        Integer[] right = Arrays.copyOfRange(keys, parentPos + 1, keys.length);

        // Add children to last parent
        if(left.length > 0)
            parent.left = new BinaryTreeNode(left[left.length/2]);
        if(right.length > 0)
            parent.right = new BinaryTreeNode(right[right.length/2]);

        // Recursively do this for keys.
        mkTreeHelper(parent.left, left.length/2, left);
        mkTreeHelper(parent.right, right.length/2, right);
    }


    static class Debug {

        enum TreeOrder {
            PREORDER, INORDER, POSTORDER
        }

        /* Displaying Tree */
        public static String display(BinaryTreeNode T, TreeOrder traversalOrder) {
            switch (traversalOrder) {
                case INORDER:
                    return displayInorder(T);
                case PREORDER:
                    return displayPreorder(T);
                case POSTORDER:
                    return displayPostorder(T);
                default:
                    return "";
            }
        }

        private static String displayInorder(BinaryTreeNode T) {
            if (T == null) return "";
            return displayInorder(T.left) +
                        T.key + " " +
                        displayInorder(T.right);
        }

        private static String displayPreorder(BinaryTreeNode T) {
            if (T == null) return "";
            return  T.key + " " +
                    displayPreorder(T.left) +
                    displayPreorder(T.right);
        }

        private static String displayPostorder(BinaryTreeNode T) {
            if (T == null) return "";
            return displayPostorder(T.left) +
                    displayPostorder(T.right) +
                    T.key + " ";
        }

    }


}
