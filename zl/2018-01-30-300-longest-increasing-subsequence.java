import java.util.Arrays;

class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0)
      return 0;
    int[] dp = new int[nums.length + 1];
    Arrays.fill(dp, 1);
    int res = 1;
    for (int i = 2; i <= nums.length; i++) {
      for (int j = 1; j < i; j++) {
        if (nums[i - 1] > nums[j - 1]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          res = Math.max(dp[i], res);
        }
      }
    }

    return res;
  }
}