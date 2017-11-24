class Solution {
    public int uniquePaths(int m, int n) {

        if(m==1||n==1)
            return 1;
        int[][] dp = new int[m][n];
        int i,j;
        for(i=0;i<n;i++)
            dp[0][i]=1;
        for(j=0;j<m;j++)
            dp[j][0]=1;
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];   
    }
}