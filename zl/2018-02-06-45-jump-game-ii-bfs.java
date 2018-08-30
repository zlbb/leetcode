import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int jump(int[] nums) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(0);
    queue.add(null);
    int dis = 0;
    int max = 0;
    while (true) {
      Integer t = queue.poll();
      if (t != null) {
        if (t == nums.length - 1)
          return dis;
        for (int i = Math.max(t, max) + 1; i <= t + nums[t] && i < nums.length ; i++) {
          queue.add(i);
          max = i;
        }
      } else {
        dis++;
        if (queue.size() != 0)
          queue.add(null);
      }
    }
  }
}