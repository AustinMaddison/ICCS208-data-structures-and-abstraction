import java.util.Arrays;

public class MissingTile implements Grid {


    public static void tileGrid(Grid board) {
        tilingHelper(board.size(), 0, 0, board.getPaintedCellX(), board.getPaintedCellY(), board);
    }

    static void tilingHelper(int n, int topX, int topY, int paintedX, int paintedY, Grid bd) {

        // Base Step when 2^n == 2
        // Paint in correct triomino depending where the current painted cell is.
        if (n == 2) {

            // Top right quadrant
            if (paintedX - topX >= n / 2 & paintedY - topY < n / 2) {
                bd.setTile(paintedX, paintedY, 0);
            }

            // Bottom right quadrant
            if (paintedX - topX >= n / 2 & paintedY - topY >= n / 2) {
                bd.setTile(paintedX, paintedY, 1);
            }

            // Bottom left quadrant
            if (paintedX - topX < n / 2 & paintedY - topY >= n / 2) {
                bd.setTile(paintedX, paintedY, 2);
            }

            // Top left quadrant
            if (paintedX - topX < n / 2 & paintedY - topY < n / 2) {
                bd.setTile(paintedX, paintedY, 3);
            }

        }


        // Inductive Step when 2^n > 2
        if (n > 2) {
            // Paint middle cells.
            // Top right quadrant
            if (paintedX - topX >= n / 2 & paintedY - topY <= n / 2) {
                bd.setTile(n / 2, n / 2 - 1, 0);
            }

            // Bottom right quadrant
            if (paintedX - topX >= n / 2 & paintedY - topY >= n / 2) {
                bd.setTile(n / 2, n / 2, 1);
            }

            // Bottom left quadrant
            if (paintedX - topX < n / 2 & paintedY - topY >= n / 2) {
                bd.setTile(n / 2 - 1, n / 2, 2);
            }

            // Top left quadrant
            if (paintedX - topX < n / 2 & paintedY - topY < n / 2) {
                bd.setTile(n / 2 - 1, n / 2 - 1, 3);
            }

            // recursive: subdivide grid into sub quadrants.
            // Top right quadrant
            if (paintedX - topX >= n / 2 & paintedY - topY <= n / 2) {
                tilingHelper(n / 2, n / 2, 0, paintedX, paintedY, bd);  // top right
                tilingHelper(n / 2, n / 2, n / 2, n / 2, n / 2, bd);    // bottom right
                tilingHelper(n / 2, 0, n / 2, n / 2 - 1, n / 2, bd);    // bottom left
                tilingHelper(n / 2, 0, 0, n / 2 - 1, n / 2 - 1, bd);    // top left
            }

            // Bottom right quadrant
            if (paintedX - topX >= n / 2 & paintedY - topY >= n / 2) {
                tilingHelper(n / 2, n / 2, 0, n / 2, n / 2 - 1, bd);          // top right
                tilingHelper(n / 2, n / 2, n / 2, paintedX, paintedY, bd);    // bottom right
                tilingHelper(n / 2, 0, n / 2, n / 2 - 1, n / 2, bd);          // bottom left
                tilingHelper(n / 2, 0, 0, n / 2 - 1, n / 2 - 1, bd);          // top left
            }

            // Bottom left quadrant
            if (paintedX - topX < n / 2 & paintedY - topY < n / 2) {
                tilingHelper(n / 2, n / 2, 0, n / 2, n / 2 - 1, bd);          // top right
                tilingHelper(n / 2, n / 2, n / 2, n / 2, n / 2, bd);           // bottom right
                tilingHelper(n / 2, 0, n / 2, paintedX, paintedY, bd);        // bottom left
                tilingHelper(n / 2, 0, 0, n / 2 - 1, n / 2 - 1, bd);          // top left
            }

            // Top left quadrant
            if (paintedX - topX < n / 2 & paintedY - topY < n / 2) {
                tilingHelper(n / 2, n / 2, 0, n / 2, n / 2 - 1, bd);          // top right
                tilingHelper(n / 2, n / 2, n / 2, n / 2, n / 2, bd);           // bottom right
                tilingHelper(n / 2, 0, n / 2, n / 2 - 1, n / 2, bd);          // bottom left
                tilingHelper(n / 2, 0, 0, paintedX, paintedY, bd);            // top left
            }
        }
    }

    @Deprecated
    public int size() {
        return 0;
    }

    @Deprecated
    public int getPaintedCellX() {
        return 0;
    }

    @Deprecated
    public int getPaintedCellY() {
        return 0;
    }

    @Deprecated
    public boolean setTile(int x, int y, int orientation) {
        return false;
    }

    @Deprecated
    public boolean isFullyTiled() {
        return false;
    }
}
