import java.util.Arrays;

public class RecursivePal<T> {
    // hint: don't forget .equals vs. ==
    public boolean isRecursivePalindrome(T[] a) {
        if(a.length == 0)
            return true;
        if(a.length == 2)
            return isPalindrome(a);

        if(isPalindrome(a))
            return isRecursivePalindrome(Arrays.copyOfRange(a,0, a.length/2));

        return false;
    }

    public boolean isPalindrome(T[] a) {
        int i = 0;
        int j = a.length - 1;
        while(i*2 < a.length){
            if(!a[i].equals(a[j]))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a0 = {1, 1, 5, 1, 1};
        Integer[] a1 = {7, 8, 7, 7, 8, 7};
        Integer[] a2 = {2, 0, 4, 0, 2};
        Integer[] a3 = {7, 4, 5, 5, 4, 7, 9, 7, 4, 5, 5, 4, 7};

        System.out.println(new RecursivePal<>().isRecursivePalindrome(a0)); // expect: true
        System.out.println(new RecursivePal<>().isRecursivePalindrome(a1)); // true
        System.out.println(new RecursivePal<>().isRecursivePalindrome(a2)); // false
        System.out.println(new RecursivePal<>().isRecursivePalindrome(a3)); // false



    }
}
