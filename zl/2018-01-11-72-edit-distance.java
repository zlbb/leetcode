import java.util.Arrays;

class Solution {
  public int min(int a,int b,int c){

    return Math.min(Math.min(a, b), c);
  }
  public int minDistance(String word1, String word2) {
    int m = word1.length() + 1;
    int n = word2.length() + 1;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i < n; i++) {
      dp[0][i] = i;
    }
    for(int i =1;i<m;i++){
      for(int j = 1;j<n;j++){

        dp[i][j]= min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+(word1.charAt(i-1) == word2.charAt(j-1)?0:1) );
      }
      
    }

    
    return dp[m-1][n-1];
  }
}

System.out.println(new Solution().minDistance("horse","ros"));