/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    var sortedNums = nums.map((item, idx) => ({ val: item, idx: idx })).sort((i, j) => i.val - j.val)
    var i = 0, j = nums.length - 1
    while (i < j) {
        var sum = sortedNums[i].val + sortedNums[j].val
        if (sum == target) {
            return [sortedNums[i].idx, sortedNums[j].idx]
        } else if (sum > target) {
            j--
        } else {
            i++
        }
    }
};