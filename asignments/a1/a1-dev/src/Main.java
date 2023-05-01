import A1.Fib;
import A1.Happy;
import A1.Hidden;
import A1.Subsel;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /* Task 2 - A1.Diamond */
//        A1.Diamond.printDiamond(10);
        
        /* Task 3 - A1.Roman to Number */
//        System.out.println(A1.Roman.romanToInt("IV"));
//        System.out.println(A1.Roman.romanToInt("I"));
//        System.out.println(A1.Roman.romanToInt("VII"));
//        System.out.println(A1.Roman.romanToInt("MCMLIV"));
//        System.out.println(A1.Roman.romanToInt("MCMXC"));

        /* Task 4 - NDigit Fibonacci Number */
//        System.out.println(Fib.firstNDigit(1));
//        System.out.println(Fib.firstNDigit(100));

        /* Task 5 - Subsel */
//        int[] a;
//        int[] b;
//
//        a = new int[] {8, 7, 9, 1, 3, 4, 8, 2, 4, 8, 6, 5, 7, 9, 1};
//        b = Subsel.takeEvery(a, 1, 2);
//        System.out.println(Arrays.toString(b));
//
//
//        a = new int[] {1, 2, 3, 4};
//        b = Subsel.takeEvery(a, 2);
//        System.out.println(Arrays.toString(b));
//
//        a = new int[] {2, 7, 1, 8, 4, 5};
//        b = Subsel.takeEvery(a, 3, 2);
//        System.out.println(Arrays.toString(b));
//
//
//        a = new int[] {3, 1, 4, 5, 9, 2, 6, 5};
//        b = Subsel.takeEvery(a, -1, 5);
//        System.out.println(Arrays.toString(b));

        /* Task 6: Happy Time, Once Again*/
//        long a;
//        a = Happy.sumOfDigitsSquared(199);
//        boolean a;
//        assert Happy.isHappy(19) == true;
//        assert Happy.isHappy(100) == true;
//        assert Happy.isHappy(111) == false;
//        assert Happy.isHappy(1234) == false;
//        assert Happy.isHappy(989) == true;

//        System.out.println(Arrays.toString(Happy.firstK(11)));


        /* Task 6 - Hidden String */

        assert Hidden.isHidden("welcometothehotelcalifornia","melon") == true;
        assert Hidden.isHidden("welcometothehotelcalifornia","space") == false;
        assert Hidden.isHidden("TQ89MnQU3IC7t6","MUIC") == true;
        assert Hidden.isHidden("VhHTdipc07","htc") == false;
        assert Hidden.isHidden("VhHTdipc07","hTc") == true;




    }

}