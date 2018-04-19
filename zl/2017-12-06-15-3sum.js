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

var threeSum = function (nums) {

  var sortedNums = nums.map((item, idx) => ({ val: item, idx: idx, skip: 0 })).sort((i, j) => i.val - j.val)

  res = []
  let begin = new Date()
  for (var i = 0; i < nums.length; i++) {
    if(i>=1 && nums[i] == nums[i-1]){
      continue
    }
    sortedNums[(i - 1) > 0 ? i - 1 : 0].skip = 0
    sortedNums[i].skip = 1
    var t = twoSum(sortedNums, -sortedNums[i].val)
    t = t.map(item => {
      item.push(sortedNums[i].idx)
      return item.map(i => nums[i])
    })
    res = res.concat(t)
  }
  console.log(new Date() - begin)
  res = [
    ...new Set(
      res.map(i =>
        i.sort((i, j) => i - j).join(",")
      )
    )
  ].map(i => i.split(",").map(i => +i))
  return res
};

console.log(threeSum([-1, 0, 1, 2, -1, -4]))

let begin = new Date()
threeSum(new Array(3000).fill(0))
console.log(new Date() - begin)