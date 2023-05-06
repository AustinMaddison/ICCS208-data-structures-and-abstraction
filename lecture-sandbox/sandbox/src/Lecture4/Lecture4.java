package Lecture4;

public class Lecture4 {
    public static void main(String[] args) {
        SLList L = new SLList();
        L.addFirst(1);
        L.addFirst(12);
        L.addLast(3);
        L.addLast(4);
        L.addFirst(20);

        System.out.println(L.toString());
        System.out.println(L.size());
        System.out.println(L.getFirst());
        System.out.println(L.getLast());
        System.out.println(L.toString());
        L.removeFirst();
        System.out.println(L.toString());
        L.insert(-1, 0);
        System.out.println(L.toString());
        System.out.println(L.size());

        L.insert(-1, 4);
        System.out.println(L.toString());



    }
}
