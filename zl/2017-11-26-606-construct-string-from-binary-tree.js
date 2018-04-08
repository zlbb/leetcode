/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} t
 * @return {string}
 */
var tree2str = function(root) {
  if(root == null){
    return ''
  }
  var res = ''
  function helper(root){

    res += '(' + root.val

    if(root.left == null && root.right != null){
      res += '()'
    }
    if(root.left != null){
      helper(root.left)
    }
    if(root.right != null){
      helper(root.right)
    }
    res += ')'
  }
  helper(root)
  return res.slice(1,-1)
};