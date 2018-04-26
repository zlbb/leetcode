import java.util.ArrayList;
import java.util.List;

class Solution {
  List<List<Integer>> res;
  List<Integer> stack;
  int sum;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    res = new ArrayList<List<Integer>>();
    stack = new ArrayList<>();
    sum = 0;
    helper(candidates, target, 0);
    return res;
  }

  void helper(int[] candidates, int target, int i) {
    for (int j = i; j < candidates.length; j++) {
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
        helper(candidates, target, j);
        stack.remove(stack.size() - 1);
        sum -= candidates[j];
      } else {
        return;
      }
    }
  }
}