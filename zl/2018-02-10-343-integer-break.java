class Solution {
  public int integerBreak(int n) {
    int dp[] = new int[n+10];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    for(int i=3;i<=n;i++){
      for(int j=1;j<i;j++){
        dp[i] = Math.max(dp[i-j]*j,dp[i]);
      }
    } 
    return n<=3?n-1:dp[n];
  }
}