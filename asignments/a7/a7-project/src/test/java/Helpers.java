public class Helpers {

    static class Debug {

        enum TreeOrder {
            PREORDER, INORDER, POSTORDER
        }

        /* Displaying Tree */
        public static String display(BinaryTreeNode T, Helpers.Debug.TreeOrder traversalOrder) {
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
            return T.key + " " +
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
