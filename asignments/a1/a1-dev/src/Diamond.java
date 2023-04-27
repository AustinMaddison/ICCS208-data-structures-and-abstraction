/**
 * @author Austin Maadison
 * @date 27/04/2023
 */
public class Diamond {
    public static void printDiamond(int k){
        int width = k*2 + 1;
        int height = k*2 -1;
        char[][] map = new char[k][width];

        /* render half+middle of diamond to map */
        for(int row = 0; row < k; row++){
            int hashes = k*2 -(row*2);
            int stars = width - hashes;
            int column = 0;
            for(int left_hashes = hashes/2; left_hashes > 0; left_hashes--){
                map[row][column] = '#';
                column++;
            }
            for(; stars > 0; stars--){
                map[row][column] = '*';
                column++;
            }
            for(int right_hashes = hashes/2; right_hashes > 0; right_hashes--){
                map[row][column] = '#';
                column++;
            }
        }

        /* print map to console including reflection for bottom */
        for(int row = 0; row < k; row++){
            for(int col = 0; col < width; col++){
                System.out.print(map[row][col]);
            }
            System.out.printf("%n");
        }
        for(int row = k-2; row >= 0; row--) {
            for(int col = 0; col < width; col++){
                System.out.print(map[row][col]);
            }
            System.out.printf("%n");
        }
    }
}
