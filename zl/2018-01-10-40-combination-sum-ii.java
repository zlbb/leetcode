import java.util.ArrayList;
import java.util.List;

class Solution {
  List<List<Integer>> res;
  List<Integer> stack;
  int sum;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    res = new ArrayList<List<Integer>>();
    stack = new ArrayList<>();
    sum = 0;
    helper(candidates, target, 0);
    return res;
  }

  void helper(int[] candidates, int target, int i) {
    for (int j = i; j < candidates.length; j++) {
      if (j > 0 && j != i && candidates[j - 1] == candidates[j])
        continue;
      if (sum + candidates[j] == target) {
        stack.add(candidates[j]);
        List<Integer> temp = new ArrayList<>();
        for (Integer t : stack) {
          temp.add(t);
        }
        res.add(temp);
        stack.remove(stack.size() - 1);
      } else if (sum + candidates[j] < target) {
        stack.add(candidates[j]);
        sum += candidates[j];
        helper(candidates, target, j + 1);
        stack.remove(stack.size() - 1);
        sum -= candidates[j];
      } else {
        return;
      }
    }
  }
}

//System.out.println(new Solution().combinationSum2(new int[]{1,1,2,5,6,7,10},8));
