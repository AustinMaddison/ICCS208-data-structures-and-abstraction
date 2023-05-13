package Lecture6;

    class A {
        int y;
        A(int x) {
            System.out.printf("A(%d)\n", x);
            y = 2*x+1;
        }
        A() {
            this(3);
            System.out.println("A()");
        }
    }

    // Create a subclass by extending class A.
    class B extends A {
        B(String st) {
            System.out.printf("B(st:%s)\n", st);
        }
        B(int val) {
            this(Integer.toString(val));
            System.out.printf("B(val:%d)\n", val);
        }
        B() {
            this(1);
            System.out.println("B()");
        }
    }

    public class Snippet {
        public static void main(String args[]) {
            B b = new B();
        }
    }

