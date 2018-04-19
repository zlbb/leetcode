
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
  res = []
  back("", n, n)
  function back(pattern, open, close) {
    let isValid = valid(pattern)
    if (open == 0 && close == 0 && isValid == 0) {
      res.push(pattern)
    }
    if (open <= close && isValid >= 0) {
      if (open > 0) {
        pattern += "("
        back(pattern, open - 1, close)
        pattern = pattern.slice(0, -1)
      }
      if (close > 0) {
        pattern += ")"
        back(pattern, open, close - 1)
        pattern = pattern.slice(0, -1)
      }
    }
  }
  function valid(pattern) {
    let sum = 0
    for (let c of pattern) {
      if (c == '(') {
        sum++
      } else if (c == ')') {
        sum--
        if (sum < 0)
          return -1
      }
    }
    return sum
  }
  return res

};

console.log(generateParenthesis(3))
