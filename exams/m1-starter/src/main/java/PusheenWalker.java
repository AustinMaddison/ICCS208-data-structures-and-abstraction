import java.util.List;
import java.util.Iterator;

public class PusheenWalker<T> implements Iterable<T> {

    List<List<T>> list;

    public PusheenWalker(List<List<T>> tb) {
        list = tb;
    }

    private class PusheenWalkerIterator implements Iterator<T> {

        int currentRow = 0;
        int currentColumn = 0;


        @Override
        public boolean hasNext() {
            return currentRow < list.size();
        }

        @Override
        public T next() {
            while(list.get(currentRow).size() == 0){
                currentRow++;
            }

            T returnValue = list.get(currentRow).get(currentColumn++);

            if (currentColumn == list.get(currentRow).size()) {
                currentColumn = 0;
                currentRow++;
            }

            return returnValue;
        }

        private boolean isRowEmpty() {
            return list.get(currentRow).size() == 0;
        }

        private boolean isLastRowEmpty() {
            return list.get(list.size()-1).size() == 0;
        }

    }


    public Iterator<T> iterator() {

        return new PusheenWalkerIterator();
    }

}
