public class Main {

    public static void main(String[] args) {

        // Exercise Max with for and while.
//        int[] nums = new int[] {3, 1, 4, 2, 8};
//        System.out.println(Max.maxFor(nums));
//        System.out.println(Max.maxWhile(nums));
//        System.out.println(Max.maxCStyleFor(nums));

        //printing an array
//        System.out.println(nums); // prints address of the array


        System.out.println(Exercise2.numTrailingZeros(20)); // prints address of the array

        int[] a = {1, 2, -3, 4, 5, 4};
//        int[] a = {1, -1, -1, 10, 5, -1};
        int n = 3;
//        int n = 2;
        Exercise2.windowPosSum(a, n);

        for(int num: a)
        {
            System.out.println(num);
        }
    }
}
