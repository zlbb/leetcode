class Solution {
  void dfs(int row, int col, char[][] grid) {
    grid[row][col] = '0';
    if (inBox(row + 1, col, grid) && grid[row + 1][col] == '1') {
      dfs(row + 1, col, grid);
    }
    if (inBox(row - 1, col, grid) && grid[row - 1][col] == '1') {
      dfs(row - 1, col, grid);
    }
    if (inBox(row, col + 1, grid) && grid[row][col + 1] == '1') {
      dfs(row, col + 1, grid);
    }
    if (inBox(row, col - 1, grid) && grid[row][col - 1] == '1') {
      dfs(row, col - 1, grid);
    }
  }

  public int numIslands(char[][] grid) {
    int num = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(i, j, grid);
          num++;
        }
      }
    }
    return num;
  }

  boolean inBox(int row, int col, char[][] grid) {
    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length)
      return true;
    return false;
  }
}