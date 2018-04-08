/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function (preorder, inorder) {
    if (preorder.length == 0) {
        return null
    }
    else if (preorder.length == 1) {
        return new TreeNode(preorder[0])
    } else {
        var leftNum = inorder.indexOf(preorder[0])
        var node = new TreeNode(preorder[0])
        node.left = buildTree(preorder.slice(1, leftNum + 1), inorder.slice(0, leftNum))
        node.right = buildTree(preorder.slice(leftNum + 1, preorder.length), inorder.slice(leftNum + 1, inorder.length))
        return node
    }
};

