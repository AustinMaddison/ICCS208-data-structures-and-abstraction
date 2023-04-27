public class Diamond {
    public static void printDiamond(int k){
        int width = k*2 + 1;
        int height = k*2 -1;

        for(int row = 0; row < height; row++){

            for(int column = 0; column < width; column++){
                System.out.print("#");
                System.out.print("*");
            }
            System.out.printf("%n");
        }





    }
}
