var reverse = function (x) {
  let y = Math.abs(x)
  let t = parseInt(y.toString().split("").reverse().join(""))
  let maxInt = parseInt('0x7fffffff', 16)
  if (t > maxInt) {
    return 0
  }
  return y == x ? t : -t
};