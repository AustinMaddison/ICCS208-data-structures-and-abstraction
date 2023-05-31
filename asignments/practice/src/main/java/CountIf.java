public class CountIf <T> {
    Predicate operator;

    CountIf(Predicate predicate) {
        operator = predicate;
    }

    public int count(T[] items) {
        int count = 0;
        for(int idx = 0; idx < items.length; idx++) {
            if(operator.test(items[idx])) {
                count++;
            }
        }
        return count;
    }

}



