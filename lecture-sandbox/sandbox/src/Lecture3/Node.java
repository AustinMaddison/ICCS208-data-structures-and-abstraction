package Lecture3;
public class Node {
    public Node(int head, Node next) {
        this.head = head;
        this.next = next;
    }

    public String toString() {
        if (this.next == null){
            // a lone node
            return Integer.toString(this.head);
//            return "" + this.head;
        }
        else { // this plus a list
            return Integer.toString(this.head) + ", "+
                    this.next.toString();
        }
    }
    public int size() {
        if (this.next == null) {
            return 1;
        }
        else
            return 1 + this.next.size();
    }
    public int recSize(Node list) {
        if (list == null) {
            return 0;
        }
        else
            return 1 + this.next.recSize(list.next);
    }

    public static int iterSize(Node list) {
        int size = 0;
        for(Node current = list; current != null; current = current.next )
            size++;
        return size;
    }

    public int head;
    public Node next;
    public int data;
}
