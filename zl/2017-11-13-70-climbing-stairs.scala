object Solution {
  def climbStairs(n: Int): Int = {
    var curr = 1
    var prev = 0
    var t = 0
    for(i <- 1 to n) {
      t = curr
      curr = curr + prev
      prev = t
    }
    curr
  }
}