import java.util.Arrays;

class Solution {
  public int maxProduct(int[] nums) {
    int res = nums[0];
    for (int i = 1, max = res, min = res; i < nums.length; i++) {
      if (nums[i] < 0) {
        int t = max;
        max = min;
        min = t;
      }

      max = Math.max(nums[i], max * nums[i]);
      min = Math.min(nums[i], min * nums[i]);
      res = Math.max(max, res);
    }
    return res;
  }
}