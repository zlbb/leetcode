object Solution {
    def setZeroes(matrix: Array[Array[Int]]): Unit = {
        val m = matrix.length
        val n = matrix(0).length

        val zeroIndex = for(
          i <- 0 until m;
          j <- 0 until n;
          if(matrix(i)(j) == 0)
        ) yield (i,j)

        zeroIndex.foreach{
          case (i,j) => set(matrix,i,j,m,n)
        }
    }
    def set(matrix: Array[Array[Int]], i:Int, j:Int, m: Int, n: Int): Unit = {
      for(x <- 0 until m){
        matrix(x)(j) = 0
      }
      for(y <- 0 until n){
        matrix(i)(y) = 0
      }
    }
}