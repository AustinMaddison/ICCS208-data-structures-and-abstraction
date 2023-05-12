package Lecture6;

import java.util.ArrayList;
import java.util.List;



interface Series {
    int next();
    void reset();
}


class IncreByTwo implements Series {

    private int counter = 0;

    public int next() {
        int prev_counter = counter;
        counter += 2;
        return  prev_counter;
    }

    public void reset() {
        counter = 0;
    }
}


class IncreByFive implements Series {

    private int counter = 0;

    public int next() {
        int prev_counter = counter;
        counter += 5;
        return  prev_counter;
    }

    public void reset() {
        counter = 0;
    }
}

class ConstByFive implements Series {

    private int counter = 0;

    public int next() {
        int prev_counter = counter;
        counter = 5;
        return  prev_counter;
    }

    public void reset() {
        counter = 0;
    }
}

public class L6 {
    // instead of overloading ArrayList and LinkedList to sumAll just use interface.
    static int sumAll(List<Integer> ll) {
        int sum = 0;
        for (int number: ll) sum += number;
        return sum;
    }

    public static void main(String[] args) {
//      List<Integer> l = new List<>();
        List<Integer> l = new ArrayList<>();
        ConstByFive cc = new ConstByFive();
        Series c = cc;
    }
}
