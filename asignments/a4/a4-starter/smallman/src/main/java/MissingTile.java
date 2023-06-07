import java.util.Arrays;

public class MissingTile implements Grid {


    static int[][] cells;
    static int size = 0;


    public static void tileGrid(Grid board) {
        tilingHelper(board.size(), 0, 0,
                board.getPaintedCellX(), board.getPaintedCellY(), board);

    }


    static void tilingHelper(int size, int topX, int topY, int paintedX, int paintedY, Grid bd) {

    }


    private class GridView implements Grid {

        int[][] cells;
        int size;


        Grid thisGrid;
        public GridView(Grid parentGrid) {
            thisGrid = parentGrid;
            size = parentGrid.size();

            cells = new int[size][size];
        }

        public GridView subgrid(int topX, int topY, int size, int virtualPaintedX, int virtualPaintedY) {
            int xOffset = topX * (size/2);
            int yOffset = topY * (size/2);


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

    @Deprecated
    public int size() {
        return 0;
    }

    @Deprecated
    public boolean setTile(int x, int y, int orientation) {
        // TODO Auto-generated method stub
        return false;
    }

    @Deprecated
    public int getPaintedCellX() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Deprecated
    public int getPaintedCellY() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Deprecated
    public boolean isFullyTiled() {
        // TODO Auto-generated method stub
        return false;
    }


}
