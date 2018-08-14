// distinct-subsequences

// dp[i][j] = | dp[i-1][j]         // if S[i] != T[j]
//            | dp[i-1][j] + 1     // if S[i] == T[j]

// init dp[i][j] = 0 if i<j


class Solution {
  public int numDistinct(String s, String t) {
    int m = s.length()+1;
    int n = s.length() +1;
    int[][] dp = new int[m][n];

    for(int i = 1;i<m;i++){
      for(int j=1;j<=i&& j < n;j++){
        if(s.charAt(i-1) != t.charAt(j-1)){
          dp[i][j] =dp[i-1][j];
        }else{
          dp[i][j]=dp[i-1][j]+1;
        }
      }
    }
    return dp[m-1][n-1];
  }
}

System.out.println(new Solution().numDistinct("rabbbit11","rabbit111"));