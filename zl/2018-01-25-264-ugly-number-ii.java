class Solution {
    
  public int nthUglyNumber(int n) {
      long[] dp = new long [1700];
      dp[1]=1;
      
      for(int i =2;i<=n;i++){
          long min = Long.MAX_VALUE;
          for(int j = 1;j<=i;j++){
              if(dp[j] *2>dp[i-1]){
                  min = Math.min(min,dp[j]*2);
              }
              if(dp[j] *3>dp[i-1]){
                  min = Math.min(min,dp[j]*3);
              }
              if(dp[j] *5>dp[i-1]){
                  min = Math.min(min,dp[j]*5);
              }
          }
          dp[i]=min;
      }
      return (int)dp[n];
  }
}