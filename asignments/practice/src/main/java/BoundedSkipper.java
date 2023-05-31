import java.util.Iterator;
import java.util.function.Consumer;

public class BoundedSkipper implements Iterable<Integer> {
    int n, k;
    BoundedSkipper(int n, int k) {
        this.n = n;
        this.k = k;
    }

    private class boundedSkipperIterator implements Iterator<Integer> {
        int currentN = 1;

        @Override
        public boolean hasNext() {
            return currentN <= n;
        }

        @Override
        public Integer next() {
            while( isContainK() | isFactorOfK() ) {
                currentN++;
            }
            return currentN++;
        }

        boolean isContainK() {
            int digit;
            int temp = currentN;
            while(temp > 0) {
                digit = temp - (temp % 10);
                if(digit == k) {
                    return true;
                }
                temp = (temp - digit) / 10;
            }
            return false;
        }

        boolean isFactorOfK() {
            return currentN % k == 0;
        }

    }

    public Iterator<Integer> iterator() {
        return new boundedSkipperIterator();
    }

    public static void main(String[] args) {
        BoundedSkipper bs = new BoundedSkipper(11, 3);
        for(int n: bs) {
            System.out.println(n);
        }
    }
}
