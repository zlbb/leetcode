import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<Integer> rightSideView(TreeNode root) {

    List<Integer> res = new LinkedList<>();
    if (root == null)
      return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    int prev = 0;
    while (queue.size() != 0) {
      TreeNode rt = queue.poll();
      if (rt != null) {
        prev = rt.val;
        if (rt.left != null)
          queue.add(rt.left);
        if (rt.right != null)
          queue.add(rt.right);
      } else {
        res.add(prev);
        if (queue.size() != 0)
          queue.add(null);
      }
    }
    return res;
  }
}