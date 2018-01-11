/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

题目链接 https://leetcode.com/problems/3sum/#/description
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> tmp = new LinkedList<Integer>();
        
        for(int i = 0; i < length-1; i++){
            int target = -nums[i];
            int front = i+1;
            int back = length - 1;
            while(front<back){
                int sum = nums[front]+nums[back];  
                if(sum == target){
                    tmp.add(nums[i]);
                    tmp.add(nums[front]);                    
                    tmp.add(nums[back]);
                    res.add(tmp);
                    tmp = new LinkedList<Integer>();
                    while(front<back && nums[front]==nums[front+1]) front++;                
                    while(front<back && nums[back]==nums[back-1]) back--;
                    front++;
                    back--;
                }else if( sum < target){
                    front++;
                }
                else{
                    back--;
                }
            }
            while( (i<length-1) && nums[i]==nums[i+1]) i++;
        }
        return res;        
    }
}