public class Solution {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] <= o2[0] ? -1 : 1;
                }
            });
            int[] dp = new int[pairs.length];
            dp[0] = 1;
            for (int i = 1; i < pairs.length; i++) {
                dp[i] = Math.max(dp[i - 1],findLastfolowing(pairs,i)<0?0:dp[findLastfolowing(pairs, i)] + 1);
            }
            return dp[pairs.length - 1];
        }

        private int findLastfolowing(int[][] pairs, int index) {
            int res = index - 1;
            while (res >= 0 && (!(pairs[res][1] < pairs[index][0])||pairs[res][0]==pairs[index][0]) ) {
                res--;
            }
            return res;
        }
}