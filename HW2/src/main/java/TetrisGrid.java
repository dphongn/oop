//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean [][]grid;
    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }


    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        int width = grid.length;
        int height = grid[0].length;

        for (int y = 0; y < height; y++) {
            if(isFullRow(y,width)) {
                clearRow(y,width,height);
                y--;
            }
        }
    }
    private boolean isFullRow(int y, int width) {
        for (int x = 0; x < width ; x++) {
            if(!grid[x][y]) return false;
        }
        return true;
    }

    private void clearRow(int row, int width, int height) {
        for (int y = row; y < height - 1; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = grid[x][y + 1];
            }
        }
        for (int x = 0; x < width; x++) {
            grid[x][height - 1] = false;
        }
    }
    /**
     * Returns the internal 2d grid array.
     * @return 2d grid array
     */
    boolean[][] getGrid() {

        return grid; // YOUR CODE HERE
    }
}
