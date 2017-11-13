object Solution { 
  def main(args:Array[String]): Unit ={
    println(findLongestChain(
      Array(
        Array(1,2)
      )
    ))
  }
  def findLongestChain(pairs: Array[Array[Int]]): Int = {
    val sorted = pairs.sortBy(_(0))
    val len = pairs.length
    val dp = Array.ofDim[Int](len).map(i=>1)

    for(i <- 0 until len){
      for(j <- 0 until i){
        dp(i) = Math.max(dp(i),dp(j) + (if(sorted(j)(1) < sorted(i)(0)) 1 else 0))
      }
    }
    dp.last
  }
}