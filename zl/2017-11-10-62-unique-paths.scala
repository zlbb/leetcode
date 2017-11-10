object Solution {
  def main(args:Array[String]): Unit = {
    uniquePaths(3,3)
  }
  def uniquePaths(m: Int, n: Int): Int = {
    val matrix =  Array.ofDim[Int](m,n)
    matrix(m-1)(n-1) = 1
    
    for(i <- m - 1 to 0 by -1){
      for(j <- n - 1 to 0 by -1){
        matrix(i)(j) = matrix(i)(j) + (if(i + 1 < m) matrix(i+1)(j) else 0) + (if(j + 1 < n) matrix(i)(j+1) else 0)
      }
    }
    println(matrix.map{_.mkString(" ")}.mkString("\n"))
    matrix(0)(0)
  }
}