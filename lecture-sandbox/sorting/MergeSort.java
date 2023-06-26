import java.util.Arrays;
import java.util.Comparator;

public class MergeSort <K>{

    /* Merge contents of S1 and S2 into liost S properlu */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while(i + j < S.length) {
            if(  S2.length == j || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                S[i+j] =  S1[i++];          // copy ith element from S1 and increment i. 
            else
                S[i+j] = S2[j++];           // copy ith element from S2 and increment j.
        }
        
    }

    public static <K> void mergeSort(K S[], Comparator<K> comp) {
        int n = S.length;
        if(n < 2) return;

        //divide
        int mid = n /2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid); // copy first half
        K[] S2 = Arrays.copyOfRange(S, mid, n);      // copy second half
        //conquer
        mergeSort(S1,comp);  // sort copy of first half
        mergeSort(S2,comp);  // sort copy of second half
        //merge results
        merge(S1, S2, S, comp);  // merge sortec halves back into original
    }


    static class LessThan implements Comparator<Long> {

        @Override
        public int compare(Long o1, Long o2) {
            return o1.compareTo(o2);
        }

    }

    public static void main(String[] args) {
         Long[] S = {2L, 49L, 41L, 3L, 1L};

        Comparator<Long> comp = new LessThan();
        mergeSort(S, comp);

        for(Long num: S) {
            System.out.println(num);
        }
    }


}