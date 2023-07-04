import com.sun.source.tree.BinaryTree;

import java.util.Arrays;

public class MakeTree {

    public static BinaryTreeNode buildBST(int[] keys) {
        // merge sort nlog(N)
        Sort.mergeSort(keys);

        // Recursive split and add nodes to tree
        BinaryTreeNode root = new BinaryTreeNode(keys[keys.length / 2]); // root

        buildBstHelper(keys, root);
        return root;
    }

    private static void buildBstHelper(int[] keys, BinaryTreeNode parent) {
        if(keys.length == 0)
            return;

        // Split keys.
        int[] left = Arrays.copyOfRange(keys, 0, keys.length/2);
        int[] right = Arrays.copyOfRange(keys, keys.length/2 + 1, keys.length);

        // Add children.
        if(left.length>0)
            parent.left = new BinaryTreeNode(left[left.length/2]);
        if(right.length>0)
            parent.right = new BinaryTreeNode(right[right.length/2]);

        // Recursively do this until there is no keys
        buildBstHelper(left, parent.left );
        buildBstHelper(right, parent.right);
    }

    public static String display(BinaryTreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();

        sb.append(display(root.left)).append(root.key).append(" ");
        sb.append(display(root.right));

        return sb.toString();
    }

    private static class Sort {
        private static void mergeSort(int[] array) {
            if (array.length < 2)
                return;

            int[] left = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] right = Arrays.copyOfRange(array, array.length / 2, array.length);

            mergeSort(left);
            mergeSort(right);
            mergeSortHelper(array, left, right);
        }

        private static void mergeSortHelper(int[] array, int[] left, int[] right) {

            int i = 0; // left
            int j = 0; // right

            while (i + j < array.length) {
                if (j == right.length || (i < left.length && left[i] < right[j]))
                    array[i + j] = left[i++];
                else
                    array[i + j] = right[j++];

            }
        }
    }
    public static void main(String[] args) {

//        BinaryTreeNode bst = buildBST(keys);


        BinaryTreeNode bst;
        // Concrete Test
        if(false) {
            bst = new BinaryTreeNode(5);
            bst.right = new BinaryTreeNode(6);
            bst.left = new BinaryTreeNode(4);
        }

        // Keys to BST Test
        if(true) {
            int[] keys = {3, 4, 5, 1, 2, 6, 7, 8};
            bst = buildBST(keys);
        }



        System.out.println("DEBUG:");
        System.out.println(display(bst));
    }
}
