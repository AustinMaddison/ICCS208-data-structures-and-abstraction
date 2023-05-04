package Lecture3;

import Lecture3.IntNode;

public class Lecture3 {
    public static void main(String[] args) {
        /* */
//    Feline a = new Feline();
//    int x = 5;
//    Feline.update(a, x);
//    System.out.println(x);
//    System.out.println(a.w);

        /* No Constructor */
//        Node list = new Node();
//        list.head = 7;
//        list.next = new Node();
//        list.next.data = 12;
//        list.next.next = new Node();
//        list.next.next.head = 9;
//        list.next.next.next = new Node();

//        Node list =
//                new Node(7,
//                        new Node(9,
//                                new Node(10,
//                                    new Node(32, null))));

        /* We can construct it backwards, to elagantly construct linked list */

//        Node list = null;
//        list = new Node(9, list);
//        list = new Node(10, list);
//        list = new Node(45, list);
//        list = new Node(90, list);
//        list = new Node(67, list);
//        list = new Node(46, list);
//        list = new Node(3, list);

        /* Recursivley Implement Linked List */
//        Node list = null;
//        Node list1 = new Node(9, list);
//        Node list2 = new Node(10, list1);
//        Node list3 = new Node(45, list2);
//        Node list4 = new Node(90, list3);
//        Node list5 = new Node(67, list4);
//        Node list6 = new Node(46, list5);
//        Node list7 = new Node(3, list6);

//        System.out.println(list.toString()); // Java's seg fault
//        System.out.println(list4.toString()); // Prints recursively list
//        System.out.println(list7.size()); // Prints size using recursion
//        System.out.println(Node.iterSize(list7)); // Prints size using iteratively

        /* Inclass IntNode */

        IntNode head;
        head = new IntNode(0, null);

        /* Construct Linked List */
        int i = 0;

        for(IntNode current = head;i < 10; i++) {
            current.next = new IntNode(i, null);
            current = current.next;
        }





    }
}