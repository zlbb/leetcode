/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function (dividend, divisor) {
  let abs = Math.floor(Math.abs(dividend / divisor))
  if (dividend * divisor < 0) {
    return -abs < -2147483648 ? -2147483648 : -abs
  } else {
    return abs > 2147483647 ? 2147483647 : abs
  }
};