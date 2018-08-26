import java.util.Arrays;

class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int height = triangle.size();
    int[][] dp = new int[height + 1][height + 1];

    for (int i = 0; i < dp.length; i++)
      Arrays.fill(dp[i], (int)1e9);

    for (int j = 0; j < dp.length; j++) {
      dp[0][j] = 0;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i][j] = triangle.get(i - 1).get(j - 1) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
      }
    }
    for (int i = 0; i < dp.length; i++) {
      System.out.println(Arrays.toString(dp[i]));
    }
    int min = (int)1e9;
    for (int j = 0; j < dp.length; j++) {
      min = Math.min(dp[height][j], min);
    }
    return min;
  }
}