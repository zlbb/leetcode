object Solution {
    def main(args: Array[String]): Unit ={
      val arr = Array(
        Array(1,2,3,7),
        Array(10,11,12,13),
        Array(23,24,25,26)
      )
      println(searchMatrix(arr,3))
    }
    def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
       (Array[Int]() /: matrix) {_ ++ _} .find( _ == target) match{
        case Some(x) => true
        case None => false
       }
       
    }
}