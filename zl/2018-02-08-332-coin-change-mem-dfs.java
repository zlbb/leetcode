class Solution {
  int[] m;

  public int dfs(int[] coins, int amount) {
    if (amount == 0)
      return m[amount] = 0;
    if (m[amount] != (int) (-1e9 - 1))
      return m[amount];
    int res = (int) 1e9;
    for (int i : coins) {
      int remain = amount - i;
      int t;
      if (remain >= 0 && (t = dfs(coins, remain)) >= 0) {
        res = Math.min(t + 1, res);
      }
    }
    m[amount] = res == (int) 1e9 ? (int) -1e9 : res;
    return m[amount];
  }

  public int coinChange(int[] coins, int amount) {
    m = new int[amount + 1];
    for (int i = 0; i < m.length; i++) {
      m[i] = (int) (-1e9 - 1);
    }

    int res = dfs(coins, amount);
    return res < 0 ? -1 : res;
  }
}