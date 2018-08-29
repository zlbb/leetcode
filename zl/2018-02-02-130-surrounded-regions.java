class Solution {
  class Point {
    int row, col;

    Point(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  public void solve(char[][] board) {
    if (board.length == 0)
      return;
    char[][] temp = new char[board.length + 2][board[0].length + 2];
    boolean[][] keep = new boolean[board.length + 2][board[0].length + 2];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        temp[i + 1][j + 1] = (char) (board[i][j] == 'X' ? 1 : 0);
      }
    }

    Queue<Point> queue = new LinkedList<Point>();

    queue.add(new Point(0, 0));
    keep[0][0] = true;
    while (queue.size() != 0) {
      Point p = queue.poll();

      if (inBox(p.row - 1, p.col, temp) && temp[p.row - 1][p.col] == 0 && !keep[p.row - 1][p.col]) {
        queue.add(new Point(p.row - 1, p.col));
        keep[p.row - 1][p.col] = true;
      }
      if (inBox(p.row + 1, p.col, temp) && temp[p.row + 1][p.col] == 0 && !keep[p.row + 1][p.col]) {
        queue.add(new Point(p.row + 1, p.col));
        keep[p.row + 1][p.col] = true;
      }
      if (inBox(p.row, p.col - 1, temp) && temp[p.row][p.col - 1] == 0 && !keep[p.row][p.col - 1]) {
        queue.add(new Point(p.row, p.col - 1));
        keep[p.row][p.col - 1] = true;
      }
      if (inBox(p.row, p.col + 1, temp) && temp[p.row][p.col + 1] == 0 && !keep[p.row][p.col + 1]) {
        queue.add(new Point(p.row, p.col + 1));
        keep[p.row][p.col + 1] = true;
      }
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (!keep[i + 1][j + 1])
          board[i][j] = 'X';
      }
    }
  }

  boolean inBox(int row, int col, char[][] matrix) {
    if (row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length)
      return true;
    return false;
  }
}