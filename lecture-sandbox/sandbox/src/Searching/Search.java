//package Searching;
//
//public class Search {
//
//    public static int linearSearch(String[] array, String targetKey){
//
//    }
//
//
//    public static int binarySearch(String[] array, String targetKey) {
//
//        int lo = 0;
//        int hi = array.length;
//        int n = hi - lo;
//        int m = n / 2;
//
//
//
//    }
//
//    private static int listBinarySearch()
//
//
//    int primSum(int[] xs) {
//        if (xs.length == 1) return xs[0];
//        if (xs.length == 2) return xs[0] + xs[1];
//        else {
//            int[] ys = Arrays.copyOfRange(xs, 1, xs.length);
//            return xs[0]+xs[1]+primSum(ys);
//        }
//    }
//
//    int whazIt(int[] ys) {
//        if (ys.length == 0) return 0;
//        if (ys.length == 1) return ys[0];
//        int n = ys.length;
//        int m = n/2;
//        for (int i=0;i<n;i++) {
//            int theSum = 0;
//            for (int j=0;j<=i;j++) { theSum += ys[j]; }
//            ys[i] = theSum;
//        }
//        int a = whazIt(Arrays.copyOfRange(ys, 0, m));
//        int b = whazIt(Arrays.copyOfRange(ys, m, ys.length));
//        return a + b;
//    }
//
//
//}
