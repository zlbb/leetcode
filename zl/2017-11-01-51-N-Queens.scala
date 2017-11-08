object Solution {
  var res:List[List[String]] = Nil 

  def main(args:Array[String]) ={
    print(solveNQueens(1))

  }
  def solveNQueens(n: Int): List[List[String]]= {
    res = Nil
    val queens = Array.ofDim[Int](n,n)
    solve(queens,0)
    res
  }
  def solve(queens:Array[Array[Int]],row:Int):Unit = {
    val size = queens.length
    if(row < size){
      for(i <- 0 until size){
        if(valid(queens,row,i)){
          queens(row)(i) = 1
          solve(queens,row+1)
          queens(row)(i) = 0
        }
      }
    }else{
      res = res :+ queens
        .map(_.map{
          case 0 => "."
          case 1 => "Q"
        })
        .map(_.mkString(""))
        .toList
    }
  }
  def valid(arr: Array[Array[Int]], row: Int, col: Int):Boolean = {
    var res = true
    val size = arr.length
    for(i <- 0 until row) {
      if ( col - (row - i) >= 0 && col - (row - i) < size && arr(i)(col - (row - i)) == 1) {
        res = false
      } else if ( col + (row - i) >= 0 && col + (row - i) < size && arr(i)(col + (row - i)) == 1) {
        res = false
      }
      else if (arr(i)(col) == 1) {
        res = false
      }
    }
    res
  }
}