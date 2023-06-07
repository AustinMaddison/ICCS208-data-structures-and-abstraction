import java.sql.Array;
import java.util.List;
import java.util.function.Predicate;
import java.util.Arrays;

public class SLList<T> {
    // an inner storage node class
    private class Node {
        T head;
        Node next;

        Node(T head, Node next) {
            this.head = head;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(List<T> existing) {
        this();
        Node p = sentinel;
        for (T elt : existing) {
            p.next = new Node(elt, null);
            p = p.next;
            size++;
        }
    }

    // return the first item of the list
    public T getFirst() {
        return sentinel.next.head;
    }

    public void addFirst(T val) {
        sentinel.next = new Node(val, sentinel.next);
        size++;
    }

    /**
     *
     * @return
     */
    public T[] toArray() {
        T[] arrayToReturn = (T[]) new Object[size];

        int arrayIdx = 0;
        for(Node current = sentinel.next; current != null; current = current.next) {
            arrayToReturn[arrayIdx] = current.head;
            arrayIdx ++;
        }
        return arrayToReturn;
    }

    /**
     *
     * @param p
     */
    public void deleteIf(Predicate<T> p) {

        int arrayIdx = 0;
        Node current = sentinel.next;
        Node previous = sentinel;

        while (current != null) {
            // predicate is true -> delete current node and update current node.
            if (p.test( current.head )) {
                current = current.next;
                previous.next = current;
                size--;
            }
            // predicate is false -> update current node.
            else {
                current = current.next;
                previous = previous.next;
            }
        }
    }

    public SLList<T> reversed() {
        SLList<T> slListToReturn = new SLList<T>();
        T[] currentListToArray = toArray();

        for (int idx = 0; idx < size; idx++) {
            slListToReturn.addFirst(currentListToArray[idx]);
        }

        return slListToReturn;
    }

    public int size() {
        return size;
    }

    static class BanA implements Predicate<String> {
        public boolean test(String t) {
            return t.equals("a");
        }
    }

    public static void main(String[] args) {
        SLList<String> list1 = new SLList<>(List.of("J", "a", "v", "a", "S", "E"));
        SLList<String> list2 = new SLList<>(List.of("J", "a", "v", "a", "S", "E"));

        System.out.println(Arrays.toString(list1.toArray()));    // should print [J, a, v, a, S, E]

        list1.deleteIf((String e) -> e.equals(e.toUpperCase()));
        System.out.println(Arrays.toString(list1.toArray()));
        // list1 should become [a, v, a]
        list2.deleteIf(new BanA());
        System.out.println(Arrays.toString(list2.toArray()));
        // list2 should become [J, v, S, E]
        SLList<String> list3 = list2.reversed();
        System.out.println(Arrays.toString(list3.toArray()));
        // list3 is  [E, S, v, J]
    }
}
