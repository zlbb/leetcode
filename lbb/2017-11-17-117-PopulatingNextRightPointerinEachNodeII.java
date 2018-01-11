/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
   public void connect(TreeLinkNode root) {
       if(root==null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeLinkNode node;
        TreeLinkNode prenode=null;

        while(!queue.isEmpty()){
            node = queue.poll();
            if(node==null ){
                if(!queue.isEmpty()){
                    queue.add(null);
                    prenode=null;
                }
                continue;
            }else {
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                if(prenode!=null) 
                    prenode.next=node;
                prenode=node;
            }
        }
    }
}