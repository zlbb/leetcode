class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    int i = 2, j = i + 1;
    for (; j < nums.length; j++) {

      if (nums[j] != nums[i - 2]) {
        nums[i + 1] = nums[j];
        i++;
      } else {
        continue;
      }
    }
    return i;
  }
}