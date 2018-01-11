/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        res.add(root.val);
        TreeNode node;
        boolean isStart = false;

        while (!queue.isEmpty()){
             node=queue.poll();
             if(node!=null){
                 if(node.right!=null) queue.add(node.right);
                 if(node.left!=null) queue.add(node.left);
                 if(isStart) {
                     res.add(node.val);
                     isStart=false;
                 }

             }else {
                 if(!queue.isEmpty()){
                     queue.add(null);
                     isStart=true;
                 }
             }
        }

        return res;
    }
}