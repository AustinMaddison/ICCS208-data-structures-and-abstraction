public class Last {

    public static Integer binarySearchLast(int[] a, int k) {
        Integer idx = binarySearch(a, k);

        if(idx == null) return null;

        // Iterates to last index.
        while(idx < a.length-1 && a[idx + 1] == k)
            idx++;

        return idx;
    }

    private static Integer binarySearch(int[] a, int k) {
        int low = 0;
        int high = a.length-1;

        while(low <= high) {

            // Recalculate middle position.
            int mid = (high - low) / 2 + low;

            if(k < mid) {
                high = mid - 1;
            }
            if(k > mid) {
                low = mid  + 1;
            }

            // Found.
            if(k == a[mid]) {
                return  mid;
            }
        }

        // Not found.
        return null;
    }


}
