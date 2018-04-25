class Solution {
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0)
      return new int[] { -1, -1 };
    return new int[] { binLowSearch(nums, target), binHighSearch(nums, target) };
  }

  public int binLowSearch(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (r - l > 1) {
      int mid = (l + r) / 2;
      if (nums[mid] < target) {
        l = mid;
      } else {
        r = mid;
      }
    }
    return nums[l] == target ? l : nums[r] == target ? r : -1;
  }

  public int binHighSearch(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (r - l > 1) {
      int mid = (l + r) / 2;
      if (nums[mid] <= target) {
        l = mid;
      } else {
        r = mid;
      }
    }
    return nums[r] == target ? r : nums[l] == target ? l : -1;
  }
}