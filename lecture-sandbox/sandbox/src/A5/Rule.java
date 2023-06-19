package A5;

public class Rule {
    public static void printRuler(int n) {
        if (n > 0) {
            printRuler(n-1);
            // print n dashes
            for (int i=0;i<n;i++) System.out.print('-');
            System.out.println();
            // --------------
            printRuler(n-1);
        }
    }


    public static void main(String[] args) {
        System.out.println("n=1");
        printRuler(1);
        System.out.println("n=2");
        printRuler(2);
        System.out.println("n=3");
        printRuler(3);
        System.out.println("n=4");
        printRuler(4);
    }
}
