/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (sortedNums, target) {

  var i = 0, j = sortedNums.length - 1
  var res = []
  while (i < j) {
    if (sortedNums[i].skip) {
      i++
      continue
    }
    if (sortedNums[j].skip) {
      j--
      continue
    }
    var sum = sortedNums[i].val + sortedNums[j].val
    if (sum == target) {
      res.push([sortedNums[i].idx, sortedNums[j].idx])
      i++
    } else if (sum > target) {
      j--
    } else {
      i++
    }
  }
  return res
};

var fourSum = function (nums, target) {
  var sortedNums = nums.map((item, idx) => ({ val: item, idx: idx, skip: 0 })).sort((i, j) => i.val - j.val)

  res = []
  for (var i = 0; i < sortedNums.length; i++) {
    sortedNums[i].skip = 1
    for (var j = i + 1; j < sortedNums.length; j++) {
      sortedNums[j].skip = 1
      var t = twoSum(sortedNums, target - sortedNums[i].val - sortedNums[j].val)
      sortedNums[j].skip = 0
      t = t.map(item => {
        item.push(sortedNums[i].idx)
        item.push(sortedNums[j].idx)
        return item
      })
      res = res.concat(t)
    }
  }
  res = res.map(i => i.map(j => nums[j]))
  console.log(res)
  res = [
    ...new Set(
      res.map(i =>
        i.sort((i, j) => i - j).join(",")
      )
    )
  ].map(i => i.split(",").map(i => +i))
  return res
};

console.log(fourSum([1, 0, -1, 0, -2, 2], 0))

let begin = new Date()
//fourSum(new Array(3000).fill(0),0)
console.log(new Date() - begin)