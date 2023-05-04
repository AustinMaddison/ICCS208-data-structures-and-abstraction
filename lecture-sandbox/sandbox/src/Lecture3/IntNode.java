package Lecture3;
public class IntNode {
    int data;
    IntNode next;

    /* Constructor */
    IntNode(int data, IntNode next)
    {
        this.data = data;
        this.next = next;
    }

    public String iterativeToString(){
        String list_string = "";
        for(IntNode current = new IntNode(this.data, this.next); current != null; current = current.next ){
            list_string = list_string + Integer.toString(current.data) + ", ";
        }

        return list_string;
    }

    /* Don't worry about invalid values of i for get() and set() */
    public int get(int i) {
        IntNode current = new IntNode(this.data, this.next);
        for(int current_index = 0; current_index < i; current_index++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int i, int newValue) {
        IntNode current = new IntNode(this.data, this.next);
        for(int current_index = 0; current_index < i; current_index++) {
            current = current.next;
        }
        current.data = newValue;
    }

    public IntNode incrList(int delta) {
        if (this.next == null)
            return new IntNode(this.data + delta, null);
        else
            return new IntNode(this.data + delta, next.incrList(delta));
    }

    /* Main (Entry Point) */
    public static void main(String[] args) {


        /* Construct Linked List */

        IntNode head;
        head = new IntNode(0, null);
        int i = 1;
        for(IntNode current = head; i < 10; i++) {
            current.next = new IntNode(i, null);
            current = current.next;
        }

        /* get set */
        System.out.println(head.iterativeToString());
        System.out.println(head.get(3));
        head.set(3, 33);
        System.out.println(head.iterativeToString());

        /* incremenet list */
        head = head.incrList(-4);
        System.out.println(head.iterativeToString());
    }
}
