/**
 * @param {number[]} height
 * @return {number}
 * 算法思路：从数组两端遍历，指针初始位置分别指向首和尾，选择较矮的一端作为优化的一端，将指针不断向中部靠近，直到找到比当前值更大的一个值，重新计算最大面积。直到两端指针相遇。负责都O(n)
 * link: https://leetcode.com/problems/container-with-most-water/description/
 */
function maxArea(height){
    let i = 0, j = height.length - 1, mx = 0;
    while(i<j){
        h = Math.min(height[i], height[j]);
        mx = Math.max(mx, (j-i)*h);
        if(height[i]<height[j]){
            while(height[i]<=h) 
                i++;
        }
        else{
            while(height[j]<=h)
                j--;
        }
    }
    return mx;
}

console.log(maxArea([1,2,3,4,5,6]))