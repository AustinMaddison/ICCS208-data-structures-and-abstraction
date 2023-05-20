import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SLListTest {

    @Test
    void addFirstTest() {
        SLList l1 = new SLList();
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);
        assertEquals(1, l1.get(2));
        assertEquals(2, l1.get(1));
        assertEquals(3, l1.get(0));
    }

//    @Test
//    void getOutOfRangeTest() {
//        SLList l1 = new SLList();
//        boolean thrownException = false;
//
//        /* Index Out of List -> Throw ArrayIndexOutOfBoundsException */
//        try {
//            l1.get(4);
//        }
//        catch (ArrayIndexOutOfBoundsException e) {
//            thrownException = !thrownException;
//        }
//        finally {
////            System.out.println("ERROR::out of range");
//            assertTrue(thrownException);
//            thrownException = false;
//        }
//    }
//    @Test
//    void getEmptyTest() {
//        SLList l1 = new SLList();
//        boolean thrownException = false;
//
//        /* Empty List -> Throw ArrayIndexOutOfBoundsException */
//        SLList l2 = new SLList();
//        try {
//            l2.get(0);
//        }
//        catch (ArrayIndexOutOfBoundsException e) {
////            System.out.println("ERROR::list is empty.");
//            thrownException = !thrownException;
//        }
//        finally {
//            assertTrue(thrownException);
//            thrownException = false;
//        }
//    }

    @Test
    void getOutOfRangeTest() {
        SLList l1 = new SLList();
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);

        IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> { l1.get(4); });
    }
    @Test
    void getEmptyTest() {
        /* Empty List -> Throw ArrayIndexOutOfBoundsException */
        SLList l1 = new SLList();
        IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> { l1.get(0); });
    }
}