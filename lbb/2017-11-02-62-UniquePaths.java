ass Solution {
    public int uniquePaths(int m, int n) {
        if(m==1&n==1)
            return 1;
        if(m==1||n==1)
            return 1;
        int [][] dp = new int[m][n];
        dp[m-1][n-1]=1;
        
        // 每一个各自的路径数等于其下方和右方格子路径数之和。
        for(int i = m-1;i>=0;i--){
            for(int j = n-1; j>=0; j--){
                if(i==m-1 || j==n-1) dp[i][j]=1;
                else dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
