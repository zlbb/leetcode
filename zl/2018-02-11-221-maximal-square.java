import java.util.Arrays;

class Solution {
  public int maximalSquare(char[][] matrix) {

    int m = matrix.length;
    if(m == 0) return 0;
    int n = matrix[0].length;
    int max = 0;
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = 1;
          max = Math.max(max, dp[i][j]);
          for (int k = 1; k <= dp[i - 1][j - 1]; k++) {
            if (j - 1 - k >= 0 && i - 1 - k >= 0 && matrix[i - 1][j - 1 - k] == '1' && matrix[i - 1 - k][j - 1] == '1') {
              dp[i][j] = k + 1;
              max = Math.max(max, dp[i][j]);
            } else {
              break;
            }
          }
        }
      }
    }
    for(int i=0;i<=m;i++){
      System.out.println(Arrays.toString(dp[i]));
    }
    return max * max;
  }
}