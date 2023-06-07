package Lecture7;

interface IntUnaryFun {
    int apply(int x);
}

class DoubleFun implements IntUnaryFun {
    public int apply(int x) {
        return 2 * x;
    }
}

class IncrFun implements IntUnaryFun {
    private int delta;

    public IncrFun(int d) {
        delta = d;
    }

    public IncrFun() {
        this(1);
    }

    public int apply(int x) {
        return x + delta;
    }
}



class main {

    static int twice(IntUnaryFun f, int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        System.out.println(twice(new IncrFun(), 5));
    }
}
