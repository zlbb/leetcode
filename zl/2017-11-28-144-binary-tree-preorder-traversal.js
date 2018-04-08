var preorderTraversal = function(root) {
  var res = []
  function helper(root){
    if(root == null){
      return 
    }
    res.push(root.val)
    helper(root.left)
    helper(root.right)
  }
  helper(root)
  return res
};