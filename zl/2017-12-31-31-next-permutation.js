/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function (nums) {
  var k = -1
  for (var i = nums.length - 1; i > 0; i--) {
    if (nums[i - 1] < nums[i]) {
      k = i - 1
      break
    }
  }
  if (k == -1)
    reverse(nums, 0, nums.length - 1)
  else {
    var i = nums.length - 1
    for (; i > k; i--) {
      if (nums[k] < nums[i]) {
        break
      }
    }
    var t = nums[k]
    nums[k] = nums[i]
    nums[i] = t
    reverse(nums, k + 1, nums.length - 1)
  }
};

var reverse = function (arr, begin, end) {
  while (begin < end) {
    var t = arr[begin]
    arr[begin] = arr[end]
    arr[end] = t
    end--
    begin++
  }
}