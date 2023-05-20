public class SLList {
    private class IntNode {
        int value; // an int data item
        IntNode next; // ref to the next node

        public IntNode(int val, IntNode r) {
            this.value = val; this.next = r;
        }
    }

    private IntNode first;

    public SLList() { first = null; }

    public int get(int index) {
        if(first == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        IntNode current = first;
        for (int currentIdx = 0 ;currentIdx < index; currentIdx++ ) {

            if (current == null) {
                throw new ArrayIndexOutOfBoundsException();
            }
            current = current.next;
        }
        return current.value;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public int getFirst() {
        return first.value;
    }


    public static void main(String[] args) {
        SLList l1 = new SLList();
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);
        System.out.println(l1.get(2));
    }
}