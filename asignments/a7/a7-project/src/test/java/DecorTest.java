import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DecorTest {

    @Test
    public void testMkTree() {

        List<Integer> preOrder = new ArrayList<>(List.of(3, 4, 2, 5, 1));
        List<Integer> inOrder = new ArrayList<>(List.of(3, 2, 4, 1, 5));

        BinaryTreeNode bst = Decor.mkTree(inOrder, preOrder);
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
}