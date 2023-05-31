package histogram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SimpleHistogram<DT> implements Histogram<DT>, Iterable<DT> {

    private HashMap<DT, Integer> domainCountHashMap;
    int totalCount;

    /* CTR */
    public SimpleHistogram() {
        initialize();
    }

    public SimpleHistogram(DT[] data) {
        initialize();
        proccessHistogramFromArray(data);
    }

    public SimpleHistogram(Histogram<DT> hist) {
        initialize();
        copyHistogram(hist);
    }

    private void initialize() {
        domainCountHashMap = new HashMap<DT, Integer>();  // <domain, count>
        totalCount = 0;
    }

    /**
     * Perfomrs deep copy of input histogram into this histogram.
     * @param hist The histogram to be copied.
     */
    private void copyHistogram(Histogram<DT> hist) {
        for(DT domain: hist) {
            int domainCount = hist.getCount(domain);

            domainCountHashMap.put(domain, domainCount);
            totalCount += domainCount;
        }
    }

    /**
     * Initializes set of domains with counts (histogram) from a list of items
     * @param items An array of data.
     */
    private void proccessHistogramFromArray(DT[] items) {
        for (DT item: items) {

            // Increment existing count domain by 1.
            if(isItemExist(item)) {
                setCount(item, getCount(item) + 1);
            }

            // Start new count domain with 1.
            else {
                setCount(item, 1);
            }
            totalCount++;
        }
    }

    private boolean isItemExist(DT item) {
        return domainCountHashMap.containsKey(item);
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public int getCount(DT item) {
        if (!isItemExist(item))
            return 0;
        return domainCountHashMap.get(item);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if( o.getClass() != this.getClass() ) return false;
        if(o == this) return true;

        SimpleHistogram<DT> other = (SimpleHistogram<DT>) o;
        if(totalCount != other.totalCount) return false;

        for(DT key : domainCountHashMap.keySet()) {

            if(this.getCount(key) != other.getCount(key)) return false;
        }
        return true;
    }

    @Override
    public void setCount(DT item, int count) {
        domainCountHashMap.put(item, count);
    }

    @Override
    public Iterator<DT> iterator() {
        return domainCountHashMap.keySet().iterator();
    }

    @Override
    public String toString() {
        Set<DT> keys = domainCountHashMap.keySet();
        int totalCount = keys.size();
        int currentCount = 0;

        StringBuilder string = new StringBuilder();
        for(DT key: keys) {
            string.append(key).append(": ").append(domainCountHashMap.get(key));
            if (currentCount < totalCount - 1)
                string.append(", ");
            currentCount++;
        }
        return string.toString();
    }

}

