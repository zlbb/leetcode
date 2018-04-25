
class Solution {
  public int searchInsert(int[] nums, int target) {
    int i = 0, j = nums.length - 1;
    while (j - i > 1) {
      int mid = (i + j) / 2;
      if (nums[mid] < target) {
        i = mid;
      } else {
        j = mid;
      }
    }
    if (target <= nums[i])
      return i;
    else if (nums[i] < target && target <= nums[j])
      return j;
    else
      return j + 1;
  }
}