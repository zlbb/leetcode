//reference: https://discuss.leetcode.com/topic/79938/super-short-easy-java-o-n-solution

class Solution {
    public int findMinMoves(int[] machines) {
        int total =0,length=machines.length;
        for(int i=0;i<length;i++){
            total+=machines[i];
        }
        int average = total/length;
        if(total%length!=0)
            return -1;
        int max = 0,cnt=0;
        for(int j=0;j<length;j++)
        {
            cnt += machines[j]-average;
            max=Math.max(Math.max(Math.abs(cnt),max),machines[j]-average);
        }
        return max;
    }
}