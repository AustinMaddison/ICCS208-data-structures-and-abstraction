import com.sun.source.tree.BinaryTree;

import java.util.Arrays;

public class MakeTree {

    public static BinaryTreeNode buildBST(int[] keys) {
        // merge sort nlog(N)
        Sort.mergeSort(keys);

        // Recursive split and add nodes to tree
        BinaryTreeNode root = new BinaryTreeNode(keys[keys.length / 2]); // root
        return root;
    }



    private static BinaryTreeNode buildBstHlper(int[] keys) {
        // merge sort nlog(N)
        Sort.mergeSort(keys);

        // Recursive split and add nodes to tree
        BinaryTreeNode root = new BinaryTreeNode(keys[keys.length / 2]); // root
        return root;
    }

    public static String display(BinaryTreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();

        sb.append(root.key).append(" ");
        sb.append(display(root.left));
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

//        int[] keys = {3, 4, 5, 1, 2, 6, 7, 8};
//        BinaryTreeNode bst = buildBST(keys);
        BinaryTreeNode bst = new BinaryTreeNode(5);
        bst.right = new BinaryTreeNode(6);
        bst.left = new BinaryTreeNode(4);

        System.out.println("DEBUG:");
        System.out.println(display(bst));
    }
}
