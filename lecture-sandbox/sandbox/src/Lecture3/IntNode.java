package Lecture3;
public class IntNode {
    public int data;
    public IntNode next;
    public IntNode head;

    public IntNode(int head, IntNode next) {
        this.data = head;
        this.next = next;
        this.head = this.Int
    }

    public String toString() {
        String string = "";
        IntNode current = new IntNode(this.data, this.next);
        for( ; current != null; current = current.next )
            string = Integer.toString(current.data) + ", " + string;

        return "{ "+ string + " }";
    }

    public int get(int i) {

        IntNode current = this.next;
        for( int index = 0; next != null && index < i; current = current.next ) {
            index++;
        }
        return current.data;
    }


    public void set(int i, int newValue) {

    }
}
