object Solution {
  def main(args:Array[String]): Unit = {
    minPathSum(
      Array(
        Array(1,3,1),
        Array(1,5,1),
        Array(4,2,1)
      )
    )
  }
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length

    val matrix =  Array.ofDim[Int](m,n)
    
    for(i <- m - 1 to 0 by -1){
      for(j <- n - 1 to 0 by -1){
        matrix(i)(j) = grid(i)(j) +
          (if(i==m-1&&j==n-1)
            0
          else
            Math.min(if(i + 1 < m) matrix(i+1)(j) else Int.MaxValue , if(j + 1 < n) matrix(i)(j+1) else Int.MaxValue)
          )
      }
    }
    println(matrix.map{_.mkString(" ")}.mkString("\n"))
    matrix(0)(0)
  }
}