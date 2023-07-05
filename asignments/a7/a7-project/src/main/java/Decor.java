import java.util.Arrays;
import java.util.List;

public class Decor {


    public static BinaryTreeNode mkTree(List<Integer> inOrder, List<Integer> preOrder) {

        Integer rootKey = preOrder.get(preOrder.size() - 1);
        int rootPos = inOrder.indexOf(rootKey);

        // Create tree: create root then use helper to do it recursively for subtrees
        BinaryTreeNode root = new BinaryTreeNode(null, rootKey, null);
        mkTreeHelper(root, rootPos, (Integer[]) inOrder.toArray());

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

        private enum TreeOrder {
            PREORDER, INORDER
        }

        /* Displaying Tree */
        public static String display(BinaryTreeNode T, TreeOrder traversalOrder) {
            switch (traversalOrder) {
                case INORDER:
                    return displayInorder(T);
                case PREORDER:
                    return displayPreorder(T);
                default:
                    return "";
            }
        }

        private static String displayInorder(BinaryTreeNode T) {
            if (T == null) return "";
            StringBuilder sb = new StringBuilder();
            sb.append(displayPreorder(T.left)).append(T.key).append(" ");
            sb.append(displayPreorder(T.right));
            return sb.toString();
        }

        private static String displayPreorder(BinaryTreeNode T) {
            if (T == null) return "";
            StringBuilder sb = new StringBuilder();
            sb.append(displayPreorder(T.left)).append(T.key).append(" ");
            sb.append(displayPreorder(T.right));
            return sb.toString();
        }
    }


}
