package Lecture6;

class Animal {
    void walk(String what) {
        System.out.println("Walking on " + what + "..." );
    }
    void eat(String what) {
        System.out.println("Eating " + what + "...");
    }



}

class Pet extends Animal {
    void play(String what) {
        System.out.println("Playing with " + what + "...");
    }

}

class Dog extends Animal {

}


public class Main {

    public static void main(String[] args) {
        Pet p = new Pet();
        p.eat("your mom");
        p.play("your mom");
    }
}



