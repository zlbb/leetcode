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
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        transform(root);
    }

    public void transform(TreeNode node){
        if(node.left!=null){
            TreeNode tmp =node.right;
            node.right=node.left;
            node.left=null;
            TreeNode n=node.right;
            while(n.right!=null) n=n.right;
            if(tmp!=null) n.right=tmp;
        }
    }
}