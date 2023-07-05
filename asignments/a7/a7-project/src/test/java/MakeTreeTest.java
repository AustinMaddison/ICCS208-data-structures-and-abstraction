import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MakeTreeTest {

    @Test
    public void testMakeTree() {

        int[] keys = {1, 2, 3, 4, 5, 6, 7, 8};
        BinaryTreeNode bst = MakeTree.buildBST(keys);
        System.out.println("DEBUG:");
        System.out.println(Helpers.Debug.display(bst, Helpers.Debug.TreeOrder.POSTORDER));
    }

}