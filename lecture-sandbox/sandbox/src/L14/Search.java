//package L14;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class Search {
//    public static int linearSearch(String[] array, String targetKey) {
//
//        for(int i = 0; i < array.length; i ++){
//            if(CharSequence.compare(targetKey, array[i]) == 0) {
//                return i;
//            }
//        }
//
//        return -1;
//
//    }
//
//    public static int binarySearch(String[] array, String targetKey) {
//
//        int mid = array.length / 2;
//        int high = array.length;
//        int low = 0;
//
//        boolean foundKey = false;
//
//        while(!foundKey) {
//            if(Character.compare(targetKey, array[mid])) {
//
//            }
//            for(int i = low; i < high; i++ ) {
//
//            }
//
//        }
//
//    }
//
//
//    private static class StrCmpr implements Comparator<String> {
//        @Override
//        public int compare(String o1, String o2) {
//            int maxIdx = o1.length() <= o2.length() ? o1.length() : o2.length() ;
//
//            for(int i = 0; i <  maxIdx; i++) {
//                int comparison = Character.compare(o1.charAt(i), o2.charAt(i));
//                if(comparison != 0) {
//                    continue;
//                }
//                else {
//                    return  comparison;
//                }
//            }
//
//            return 0;
//        }
//    }
//
//
//    public static void main(String[] args) {
//
//    }
//}
//
//
//
//
//
//
//
