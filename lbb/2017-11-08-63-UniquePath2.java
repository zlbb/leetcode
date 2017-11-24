class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int i,j;
        for(i=0;i<n;i++){
            if(obstacleGrid[0][i]==1){
                dp[0][i]=0;
                break;
            }
            dp[0][i]=1;
        }
            
        for(j=0;j<m;j++){
            if(obstacleGrid[j][0]==1){
                dp[j][0]=0;
                break;
            }
            dp[j][0]=1;     
        }
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}