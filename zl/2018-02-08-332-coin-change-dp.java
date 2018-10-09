class Solution {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = -1;
    }
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      int res = (int) 1e9;
      for (int c : coins) {
        if (i - c >= 0 && dp[i - c] >= 0) {
          res = Math.min(res, dp[i - c] + 1);
        }
      }
      dp[i] = res == 1e9 ? -1 : res;
    }

    return dp[amount];
  }
}