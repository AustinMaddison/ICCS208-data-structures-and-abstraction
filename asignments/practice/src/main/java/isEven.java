public class isEven implements Predicate<Integer> {
    @Override
    public boolean test(Integer x) {
        return x % 2 == 0;
    }
}