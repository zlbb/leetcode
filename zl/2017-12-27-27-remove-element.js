/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function (nums, val) {
  if (nums.length <= 1) {
    return nums[0] == val ? 0 : 1
  }
  if (nums.indexOf(val) < 0) {
    return nums.length
  }
  let i = 0
  let prevI = i
  let j = 0
  while (j < nums.length) {
    for (; i < nums.length; i++) {
      if (nums[i] == val) {
        prevI = i
        break
      }
    }
    for (j = j <= i ? i + 1 : j; j < nums.length; j++) {
      if (nums[j] != val)
        break
    }
    if (i < nums.length && j < nums.length) {
      nums[i] = nums[j]
      nums[j] = val
    }
  }
  return prevI
};
let arr = [0, 1, 2, 2, 3, 0, 4, 2]
console.log(removeElement(arr, 2))
console.log(arr)