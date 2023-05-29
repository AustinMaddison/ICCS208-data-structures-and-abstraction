package TbCh73;

import java.util.ArrayList;
import java.util.List;

public class Change {

    public static List<Integer> change(int n) {
        switch (n) {
            case 24:
                return List.of(7 , 7, 5, 5);
            case 25:
                return List.of(5 , 5, 5, 5, 5);
            case 26:
                return List.of(7 , 7, 7, 5);
            case 27:
                return List.of( 7, 5, 5, 5, 5);
            case 28:
                return List.of(7 , 7, 7, 7);


            default:
                List<Integer> nminus5 = new ArrayList<Integer>(change(n-5));
                nminus5.add(5);
                return nminus5;

        }
    }


    public static void main(String[] args) {

        int n = 37;
        System.out.println(Change.change(n)); // use the 27 base case + 5 + 5, so cool!
    }

}
