object Solution {
  def main(args:Array[String]): Unit = {
    uniquePathsWithObstacles(
      Array(
        Array(0,0,0),
        Array(0,1,0),
        Array(0,0,0)
      )
    )
  }
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    val m = obstacleGrid.length
    val n = obstacleGrid(0).length

    val matrix =  Array.ofDim[Int](m,n)
    matrix(m-1)(n-1) = if(obstacleGrid(m-1)(n-1) == 1) 0 else 1
    
    for(i <- m - 1 to 0 by -1){
      for(j <- n - 1 to 0 by -1){
        matrix(i)(j) = matrix(i)(j) + 
          (if(obstacleGrid(i)(j) == 1) 
            0 
          else 
            (if(i + 1 < m) matrix(i+1)(j) else 0) + (if(j + 1 < n) matrix(i)(j+1) else 0)
          )  
      }
    }
    println(matrix.map{_.mkString(" ")}.mkString("\n"))
    matrix(0)(0)
  }
}