// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int rows = grid.length;
        int cols = grid[0].length;

        int minRow = rows, maxRow = -1;
        int minCol = cols, maxCol = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;

                }
            }
        }
        if (maxRow == -1) return 0;
        return (maxRow - minRow + 1) * (maxCol - minCol + 1); // YOUR CODE HERE
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     * @return number of + in grid
     */
    public int countPlus() {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char ch = grid[i][j];
                int armLen = armLength(i,j,ch);
                if (armLen >= 2) {
                    count++;
                }
            }
        }
        return count; // YOUR CODE HERE
    }

    /**
     * Tính độ dài nhánh chữ thập với tâm (r,c) và ký tự ch.
     * Trả về chiều dài nhánh nếu 4 nhánh bằng nhau, ngược lại trả về -1.
     */
    private int armLength(int r, int c, char ch) {
        if (c >= grid[r].length || grid[r][c] != ch) return -1;

        int up = 0, down = 0, left = 0, right = 0;

        // lên
        for (int i = r - 1; i >= 0; i--) {
            if (c < grid[i].length && grid[i][c] == ch) up++;
            else break;
        }
        // xuống
        for (int i = r + 1; i < grid.length; i++) {
            if (c < grid[i].length && grid[i][c] == ch) down++;
            else break;
        }
        // trái
        for (int j = c - 1; j >= 0 && grid[r][j] == ch; j--) left++;
        // phải
        for (int j = c + 1; j < grid[r].length && grid[r][j] == ch; j++) right++;

        if (up >= 1 && up == down && up == left && up == right) {
            return up;
        }
        return -1;
    }

}
