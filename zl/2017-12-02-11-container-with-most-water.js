/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (heights) {
  var i = 0, j = heights.length - 1
  var max = 0

  while (i != j) {
    if (heights[i] > heights[j]) {
      max = Math.max(max, heights[j] * (j - i))
      j--
    } else {
      max = Math.max(max, heights[i] * (j - i))
      i++
    }
  }
  return max
};