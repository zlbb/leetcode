/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function (str) {
  let t = parseInt(str) || 0
  if (t > 2147483647)
    return 2147483647
  if (t < -2147483648)
    return -2147483648
  return t
};