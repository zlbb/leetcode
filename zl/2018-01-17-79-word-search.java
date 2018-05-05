class Solution {
  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (word.charAt(0) == board[i][j] && search(board, i, j, word)) {
          return true;
        }
      }
    }
    return false;
  }

  boolean[][] visited;

  boolean search(char[][] board, int x, int y, String word) {
    if (word.length() == 1)
      return true;
    visited = new boolean[board.length][board[0].length];
    return dfs(board, x, y, word.toCharArray(), 0);
  }

  boolean dfs(char[][] board, int x, int y, char[] chars, int k) {
    
    if (k == chars.length)
      return true;

    if (board[x][y] == chars[k] && !visited[x][y]) {
      visited[x][y] = true;

      if (x + 1 < board.length && dfs(board, x + 1, y, chars, k + 1)) {
        return true;
      }
      if (x - 1 >= 0 && dfs(board, x - 1, y, chars, k + 1)) {
        return true;
      }
      if (y + 1 < board[0].length && dfs(board, x, y + 1, chars, k + 1)) {
        return true;
      }
      if (y - 1 >= 0 && dfs(board, x, y - 1, chars, k + 1)) {
        return true;
      }
      visited[x][y] = false;
    }
    return false;
  }
}