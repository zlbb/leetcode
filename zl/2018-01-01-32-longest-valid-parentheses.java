class Solution {
  public int longestValidParentheses(String s) {
    int[] dp = new int[s.length()];
    int maxLen = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (i >= 1) {
          if (s.charAt(i - 1) == '(') {
            dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
          } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
            dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
          }
        }
      }
      maxLen = Math.max(maxLen, dp[i]);
    }
    return maxLen;
  }
}

//System.out.println(new Solution().longestValidParentheses(")()())"));