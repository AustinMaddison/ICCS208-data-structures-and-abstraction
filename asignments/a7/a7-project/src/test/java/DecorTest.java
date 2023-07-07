import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DecorTest {

    @Test
    public void testMkTree() {

        List<Integer> postOrder = new ArrayList<>(List.of(3, 4, 2, 5, 1));
        List<Integer> inOrder = new ArrayList<>(List.of(3, 2, 4, 1, 5));

        BinaryTreeNode bst = Decor.mkTree(postOrder, inOrder);
        String treeString;

        System.out.print("Pre-order: ");
        treeString = Helpers.Debug.display(bst, Helpers.Debug.TreeOrder.PREORDER);
        System.out.println(treeString);


        System.out.print("Post-order: ");
        treeString = Helpers.Debug.display(bst, Helpers.Debug.TreeOrder.POSTORDER);
        System.out.println(treeString);


        System.out.print("In-order: ");
        treeString = Helpers.Debug.display(bst, Helpers.Debug.TreeOrder.INORDER);
        System.out.println(treeString);
    }

    @Test
    public  void testTreeToMapLingLing() {
        LinkedList<Integer> poo = new LinkedList<>();
        poo.addAll(List.of(2, 4, 5, 12, 10, 7));
        LinkedList<Integer> inor = new LinkedList<>(List.of(2, 4, 5, 7, 10, 12));

        BinaryTreeNode preoNinor = Decor.mkTree(poo,inor);

        System.out.print("Preorder for pronuarr: ");
        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.PREORDER));

        System.out.print("Expected Preorder: 7, 5, 4, 2, 10, 12\n");
        System.out.print("Inorder: ");
        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.INORDER));
        System.out.print("Expected Inorder:2, 4, 5, 7, 10, 12\n");
        System.out.print("Postorder: ");
        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.POSTORDER));
        System.out.print("Expected Post: 2, 4, 5, 12, 10, 7\n");
    }



    @Test
    public  void testTreeToMapLingLing2() {
        LinkedList<Integer> poo = new LinkedList<>(List.of( 10, 40, 25, 60, 90, 75, 50, 125, 175, 150, 100));
        LinkedList<Integer> inor = new LinkedList<>(List.of(10, 25, 40, 50, 60, 75, 90, 100, 125, 150, 175));

        BinaryTreeNode preoNinor = Decor.mkTree(poo,inor);

        System.out.print("Preorder: ");
        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.PREORDER));
        System.out.print("Expected Preorder: ");
        System.out.println("100, 50, 25, 10, 40, 75, 60, 90, 150, 125, 175");
        System.out.print("Inorder: ");
        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.INORDER));
        System.out.print("Expected Inorder:");
        System.out.println("10, 25, 40, 50, 60, 75, 90, 100, 125, 150, 175");
        System.out.print("Postorder: ");
        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.POSTORDER));
        System.out.print("Expected Post: ");
        System.out.println(" 10, 40, 25, 60, 90, 75, 50, 125, 175, 150, 100");
    }

}