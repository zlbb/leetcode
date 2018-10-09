import java.util.Arrays;

class Solution {
  class Rect {
    public int x;
    public int y;

    Rect() {
    }

    Rect(int x, int y) {
      this.x = x;
      this.y = y;
    }
    @Override
    public String toString() {
      return "("+x+","+y+")";
    }
  }

  public int maximalRectangle(char[][] matrix) {

    int m = matrix.length;
    if (m == 0)
      return 0;
    int n = matrix[0].length;
    int max = 0;
    Rect[][] dp = new Rect[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      Arrays.fill(dp[i], new Rect());
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
          dp[i][j] = new Rect();
          for (int k = 0; k <= dp[i - 1][j].x; k++) {
            if (i - 1 - k >= 0 && matrix[i - 1 - k][j - 1] == '1') {
                dp[i][j].x = k + 1;
            } else {
              break;
            }
          }
          for (int l = 0; l <= dp[i][j - 1].y; l++) {
            if (j - 1 - l >= 0 && matrix[i - 1][j - 1 - l] == '1') {
                dp[i][j].y = l + 1;
            } else {
              break;
            }
          }
          System.out.println(""+i+","+j+":"+dp[i][j]);
          max = Math.max(max, dp[i][j].x * dp[i][j].y);
      }
    }
    for(int i=0;i<=m;i++){
      System.out.println(Arrays.toString(dp[i]));
    }
    return max;
  }
} 