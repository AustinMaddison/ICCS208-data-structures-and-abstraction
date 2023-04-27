public class Universe {
    public static void main(String[] args) {
        // 32 bit integer
        // int short, long, byte etc.
        int x = 50_000_000 * 27 * 78 * 1500; // garbage number, too large to fit in a int

        // Static typing, determined at compile time.
        int y = 10 + '4';
        int z = 10 + 4;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
