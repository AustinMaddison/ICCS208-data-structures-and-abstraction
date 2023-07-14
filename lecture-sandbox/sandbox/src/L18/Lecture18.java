package L18;

public class Lecture18 {

    class TreeNode<E> {
        E key;

        TreeNode<E> left, right;

        public TreeNode(TreeNode<E> left, E key, TreeNode<E> right) {
            this.left = left;
            this.right = right;
            this.key = key;
        }

        public TreeNode(E key) {
            this(null, key, null);
        }
    }

    public static <T> int depth(TreeNode<T> root) {
        if (root == null) return 0;

        if (root.left == null & root.right == null) return 1;
        int leftDepth = 1 + depth(root.left);
        int rightDepth = 1 + depth(root.right);

        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    public static <T> int count(TreeNode<T> tree) {
        return tree == null ? 0 : 1 + count(tree.left) + count(tree.right);
    }

    public static String concatPreorder(TreeNode<String> tree) {
        if (tree == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(tree.key);
        sb.append(concatPreorder(tree.left));
        sb.append(concatPreorder(tree.right));
        return sb.toString();
    }

}







