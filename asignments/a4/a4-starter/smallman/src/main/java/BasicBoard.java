import java.util.Arrays;

public class BasicBoard implements Grid {
  static private final int SIZE_LIMIT = 1024;
  private int paintedX;
  private int paintedY;
  private int[][] cells; // 0 is free, > 0 occupied
  private int numCovered;

  /**
   * Checks if size is of power two.
   * @param x
   * @return
   */
  private boolean powOfTwo(int x) {
    return 0 == (x & (x - 1));
  }

  private boolean inGrid(int x, int y) {
    return (x >= 0) && (y >= 0) && (x < cells.length) && (y < cells.length);
  }

  public BasicBoard(int size, int paintedX, int paintedY) {
    if (size < 1 || size > SIZE_LIMIT || !powOfTwo(size))
      throw new RuntimeException("Board size has to be a power of 2 between 1 and 1024");

    // creates grid
    this.cells = new int[size][size];

    // if given position is not in grid
    if (!inGrid(paintedX, paintedY))
      throw new ArrayIndexOutOfBoundsException("Painted cell not in grid");


    // store the positions that are now safe to paint
    this.paintedX = paintedX;
    this.paintedY = paintedY;

    // increments the value of the cell by 1
    this.claim(paintedX, paintedY); // painted is claimed with the number 1.
  }

  public int size() { return cells.length; }

  public int getPaintedCellY() {
    return paintedY;
  }


  public int getPaintedCellX() {
    return paintedX;
  }

  /**
   * Have painted as many times as how big the grid is
   * @return
   */
  public boolean isFullyTiled() {
    return numCovered == cells.length * cells.length;
  }

  /**
   * Frees by setting value to 0
   * @param x
   * @param y
   * @return
   */
  private boolean free(int x, int y) {
    return cells[x][y] == 0;
  }

  /**
   * Increment cell value by 1
   * @param x
   * @param y
   */
  private void claim(int x, int y) {
    cells[x][y] = ++numCovered;
  }

  /**
   *
   * @param x orign x of triminoe
   * @param y origin y of triminoe
   * @param o the type of triminoe
   * @return
   */
  private int[][] cellsCovered(int x, int y, int o) {

    // position of the cells in a 2 by 2 grid
    int[][] cells = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { 0, 0 } };

    // copies the position at row o.
    int[] origin = Arrays.copyOf(cells[o], cells.length);


    // recenter at (x, y)
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < 2; j++) {
        // minus all positions by the selected origin
        cells[i][j] -= origin[j];
      }
    }

    // create covered array
    int covered[][] = new int[3][2];

    // if the row is o then copy the position + the orignal position
    for (int i = 0, c = 0; i < 4; i++) {
      if (i != o) {
        covered[c][0] = cells[i][0] + x;
        covered[c][1] = cells[i][1] + y;
        c++;
      }
    }
    return covered;
  }

  public boolean setTile(int x, int y, int orientation) {
    if (!inGrid(x, y))
      return false;
    int[][] covered = cellsCovered(x, y, orientation);

    for (int[] loc : covered) {
      int thisX = loc[0], thisY = loc[1];

      if (!inGrid(thisX, thisY) || !free(thisX, thisY))
        return false;
    }
    // kosher to place this tile
    for (int[] loc : covered) {
      int thisX = loc[0], thisY = loc[1];
      claim(thisX, thisY);
    }

    return true;
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    for(int i = 0; i < cells.length; i++) {
      for(int j = 0; j < cells.length; j++) {
        str.append(cells[i][j]);
      }
      str.append("\n");
    }
    return str.toString();
  }
}
