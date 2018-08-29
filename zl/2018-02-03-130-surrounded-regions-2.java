class Solution {

  void dfs(char[][] board, int row, int col) {
    board[row][col] = 'S';

    if (inBox(row + 1, col, board) && board[row + 1][col] == 'O') {
      dfs(board, row + 1, col);
    }
    if (inBox(row, col + 1, board) && board[row][col + 1] == 'O') {
      dfs(board, row, col + 1);
    }
    if (inBox(row - 1, col, board) && board[row - 1][col] == 'O') {
      dfs(board, row - 1, col);
    }
    if (inBox(row, col - 1, board) && board[row][col - 1] == 'O') {
      dfs(board, row, col - 1);
    }

  }

  public void solve(char[][] board) {
    if (board.length == 0)
      return;
    for (int i = 0; i < board.length; i++) {
      if (board[i][0] == 'O')
        dfs(board, i, 0);
      if (board[i][board[0].length - 1] == 'O')
        dfs(board, i, board[0].length - 1);
    }
    for (int j = 0; j < board[0].length; j++) {
      if (board[0][j] == 'O')
        dfs(board, 0, j);
      if (board[board.length - 1][j]=='O')
        dfs(board, board.length - 1, j);
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'S') {
          board[i][j] = 'O';
        } else {
          board[i][j] = 'X';
        }
      }
    }
  }

  boolean inBox(int row, int col, char[][] matrix) {
    if (row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length)
      return true;
    return false;
  }
}