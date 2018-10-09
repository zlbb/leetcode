class Solution {
  public int countNumbersWithUniqueDigits(int n) {
    int[] dp = new int[10];
    dp[0] = 1;
    dp[1] = 9;
    dp[2] = 9 * 9;
    for (int i = 3; i <= 9; i++) {
      dp[i] = dp[i - 1] * (11 - i);
    }
    if (n >= 10)
      n = 9;
    int sum = 0;
    for (int i = 0; i <= n; i++) {
      sum += dp[i];
    }
    return sum;
  }
}