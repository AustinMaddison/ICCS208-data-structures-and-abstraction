package quiz2;

public class Carry implements Attack {
    String name;
    private int magicNum = 42;

    public Carry(String name) {
        this.name = name;
        System.out.println(name + ":ready");
    }

    public Carry() {
        this("Unknown");
        System.out.println("Using default");
    }

    public void attack() {
        System.out.println(name + ":attack!");
    }

    public void heal(int n) {
        System.out.println(name + ":is healing!");
        if (n > 0)
            throw new RuntimeException("Can’t");
        System.out.println("Done!");
    }
}
