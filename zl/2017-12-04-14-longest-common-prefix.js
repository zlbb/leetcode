/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
  if (strs.length == 0) {
    return ''
  }
  return strs.reduce((prev, curr) => {
    var res = ''
    for (var i = 0; i < prev.length && i < curr.length; i++) {
      if (prev[i] == curr[i]) {
        res += prev[i]
      } else {
        break
      }
    }
    return res
  })
};