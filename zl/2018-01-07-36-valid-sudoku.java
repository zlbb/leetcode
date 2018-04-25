class Solution {
  public boolean isValidSudoku(char[][] board) {
    int[] counts = new int[10];
    Arrays.fill(counts, 0);
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.')
          continue;
        if (counts[board[i][j] - '0'] == 1)
          return false;
        counts[board[i][j] - '0'] = 1;
      }
      Arrays.fill(counts, 0);
    }
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[j][i] == '.')
          continue;
        if (counts[board[j][i] - '0'] == 1)
          return false;
        counts[board[j][i] - '0'] = 1;
      }
      Arrays.fill(counts, 0);
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int m = i / 3 * 3 + j / 3;
        int n = i % 3 * 3 + j % 3;
        if (board[m][n] == '.')
          continue;
        if (counts[board[m][n] - '0'] == 1){
          return false;
        }
        counts[board[m][n] - '0'] = 1;
      }
      Arrays.fill(counts, 0);
    }
    return true;
  }
}