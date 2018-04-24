/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
  if (nums.length <= 1) {
    return nums.length
  }
  let prev = nums[0]
  let prevIdx = 0
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] != prev) {
      prev = nums[++prevIdx] = nums[i]
    }
  }
  return prevIdx + 1
};