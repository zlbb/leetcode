class Solution {
  public int jump(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = 0;
    for (int i = 1; i < nums.length; i++) {
      int minStep = Integer.MAX_VALUE;
      for (int j = 0; j < i; j++) {
        if (nums[j] + j >= i)
          minStep = Math.min(minStep, dp[j] + 1);
      }
      dp[i] = minStep;
    }
    return dp[nums.length - 1];
  }
}