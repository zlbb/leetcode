import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    return help(nums, nums.length);
  }

  List<List<Integer>> help(int[] nums, int count) {
    if (count == 1) {
      List<List<Integer>> res = new LinkedList<>();
      List<Integer> t = new LinkedList<>();
      t.add(nums[0]);
      res.add(t);
      return res;
    }
    List<List<Integer>> temp = help(nums, count - 1);
    List<List<Integer>> res = new LinkedList<>();
    for (List<Integer> p : temp) {
      for (int i = lastIndex(p, nums[count - 1]) + 1; i < count; i++) {
        List<Integer> t = new LinkedList<>(p);
        t.add(i, nums[count - 1]);
        res.add(t);
      }
    }
    return res;
  }

  int lastIndex(List<Integer> list, int target) {
    for (int i = list.size()-1; i >= 0; i--) {
      if (list.get(i) == target) {
        return i;
      }
    }
    return -1;
  }
}