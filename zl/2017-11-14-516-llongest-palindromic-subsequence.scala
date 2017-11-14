object Solution {
  def longestPalindromeSubseq(s: String): Int = {
    val dp = Array.ofDim[Int](s.length,s.length) 
    for(i <- s.length - 1 to 0 by -1){
      dp(i)(i) = 1
      for(j <- i+1 until s.length){
        if(s(i) == s(j)){
          dp(i)(j) = dp(i+1)(j-1) + 2
        }else{
          dp(i)(j) = Math.max(dp(i+1)(j),dp(i)(j-1))
        }
      }
    }
    dp(0)(s.length-1)
  }
}