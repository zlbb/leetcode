let map = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]

var letterCombinations = function (digits) {
  if (digits == "") {
    return []
  }
  let arr = digits.split("").map(i => map[i])
  var helper = function (res, arr) {
    if (arr.length == 0) {
      return res
    }
    var t = []
    for (let i of res) {
      for (let c of arr[0]) {
        t.push(i + c)

      }
    }
    return helper(t, arr.slice(1))
  }
  return helper([""], arr)

};