/**
 * 
 * 对于任意字符串，如果头尾字符相同，那么字符串的最长子序列等于去掉首尾的字符串的最长子序列加上首尾；如果首尾字符不同，则最长子序列等于去掉头的字符串的最长子序列和去掉尾的字符串的最长子序列的较大者。

因此动态规划的状态转移方程为：

设字符串为str，长度为n，p[i][j]表示第i到第j个字符间的子序列的个数（i<=j），则：

状态初始条件：dp[i][i]=1 （i=0：n-1）

状态转移方程：dp[i][j]=dp[i+1][j-1] + 2  if（str[i]==str[j]）

                   dp[i][j]=max(dp[i+1][j],dp[i][j-1])  if （str[i]!=str[j]）
 */

class Solution {
    public int longestPalindromeSubseq(String s) {
        int  length = s.length();
        int[][] dp=new int[length][length];
        for(int i=0;i<length;i++)
            dp[i][i]=1;
        for(int j=0; j<length; j++){
            for(int i=j-1;i>=0;i--){
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][length-1];
    }
}