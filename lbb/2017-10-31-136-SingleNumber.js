/**
 * @param {number[]} nums
 * @return {number}
 * 根据异或性质：两个相同的数异或结果为0，任意数与0异或为本身。
 */
var singleNumber = function(nums) {
    return nums.reduce((res,a)=>res^a,0);
};