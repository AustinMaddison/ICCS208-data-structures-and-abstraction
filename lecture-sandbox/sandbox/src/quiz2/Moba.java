package quiz2;
public class Moba {
    public static void stageAttack(Attack o) { o.attack(); }
    public static void stageMagic(Magic o) { o.magic(); }
    public static void main(String[] args) {
        System.out.print("#1: ");
        Valhein v = new Valhein("Peter"); // #1
        System.out.print("#2: ");
        Carry c = new Carry(); // #2
        System.out.print("#3: ");
        stageAttack(v); // #3
        System.out.print("#4: ");
        stageAttack(c); // #4
        System.out.print("#5: ");
        v.magic(); // #5
        System.out.print("#6: 'Required type: Magic, Provided:Carry'\n");
//        stageMagic(c); // #6
        System.out.print("#7: ");
        stageMagic(v); // #7
        System.out.print("#8: ");
        System.out.println(v.name); // #8
        System.out.print("#9: 'magicNum' has private access in 'quiz2.Carry'\n");
//        System.out.println(c.magicNum); // #9
        System.out.print("#10: ");
// #10 begins --
        try { c.heal(3); }
        catch (RuntimeException e) {
            System.out.println("Fail to heal");
        }finally {
            System.out.println("Skill is Cooling down");
        } // #10 ends --
    }
}
