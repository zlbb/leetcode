var levelOrder = function (root) {
  if (root == null) {
    return []
  }
  var res = [[]]
  var queue = []
  queue.push(root)
  queue.push('|')
  while (queue.length != 0 && !(queue.length == 1 && queue[0] == '|')) {
    if (queue[0] == '|') {
      queue.shift()
      queue.push('|')
      res.push([])
    } else {
      var temp = queue.shift()
      res[res.length - 1].push(temp.val)
      if (temp.left) {
        queue.push(temp.left)
      }
      if (temp.right) {
        queue.push(temp.right)
      }
    }
  }
  return res
};