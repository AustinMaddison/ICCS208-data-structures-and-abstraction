import com.sun.source.tree.BinaryTree;

import java.util.Arrays;

public class MakeTree {

    public static BinaryTreeNode buildBST(int[] keys) {
        // merge sort nlog(N)
        mergeSort(keys);

        // Recursive split and add nodes to tree
        BinaryTreeNode root = new BinaryTreeNode(keys[keys.length / 2]); // root
        buildBstHelper(root, keys);

        return root;
    }

    private static void buildBstHelper(BinaryTreeNode parent, int[] keys) {
        int n = keys.length;
        int mid = n/2;

        // adding leaves
        if (mid <= 2) {
            int i = mid;
            int j = mid+1;

            while(i>=0) {
                parent.left = new BinaryTreeNode(null, keys[i--], null);
            }

            while(j<n) {
                parent.right = new BinaryTreeNode(null, keys[j++], null);
            }
        }
        buildBstHelper(parent.left, Arrays.copyOfRange(keys, 0, mid));
        buildBstHelper(parent.right, Arrays.copyOfRange(keys, mid, n));

    }


    private static void test(BinaryTreeNode parent, int[] keys) {
        int n = keys.length;
        int mid = n/2;

//        BinaryTreeNode t = new BinaryTreeNode(test(t, Arrays.copyOfRange()),keys[mid] , test(t))


    }

//    private static BinaryTreeNode testHelper(BinaryTreeNode parent) {
////        if()
//    }



    public static void preOrder(BinaryTreeNode tree) {
        if (tree == null) {
            return;
        }

        System.out.print(tree.key + " ");
        preOrder(tree.left);
        preOrder(tree.right);
    }


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


    public static void main(String[] args) {

        int[] keys = {3, 4, 5, 1, 2, 6, 7, 8};
        BinaryTreeNode bst = buildBST(keys);
        System.out.println("Binary Sort Tree Pre-order:");
        preOrder(bst);
    }
}
