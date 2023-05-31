package quiz2;


public class Valhein extends Carry
        implements Attack, Magic {
    public Valhein(String name) {
        super(name);
        System.out.println(name +
                ":choose a Valhein");
    }
    public Valhein() {
        this("Unnamed Valhein");
    }
    @Override
    public void magic() {
        System.out.println(name +
                ":use magic!");
    }
}

