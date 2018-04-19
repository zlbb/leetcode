/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */

var inorderTraversal = function (root) {
  var res = []
  function helper(root) {
    if (root == null) return
    helper(root.left)
    res.push(root.val)
    helper(root.right)
  }
  helper(root)
  return res
};