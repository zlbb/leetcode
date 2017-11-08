object Solution {

  def main(args:Array[String]):Unit = {
    val matrix = Array(
      Array(1,2,3),
      Array(4,5,6),
      Array(7,8,9)
    )
    println(spiralOrder(matrix))
  }
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    val height = matrix.length
    val width = if(height == 0 ) 0 else matrix(0).length

    helper(matrix, 0, width - 1, 0, height - 1)
  }
  def helper(matrix: Array[Array[Int]], left:Int, right:Int, top:Int, bottom:Int):List[Int] = {
    println(left,right,top,bottom)

    if (left == right)
      (for(i <- top to bottom) yield matrix(i)(right)).toList
    else if (top == bottom)
      matrix(top).slice(left,right+1).toList
    else if (left > right || top > bottom)
      Nil
    else{
      val l1 = matrix(top).slice(left,right)
      val l2 = for(i <- top until bottom) yield matrix(i)(right)
      val l3 = matrix(bottom).slice(left+1,right+1).reverse
      val l4 = for(i <- bottom until top by -1) yield matrix(i)(left) 

      println(l1.toList,l2.toList,l3.toList,l4.toList)

      l1.toList ::: l2.toList ::: l3.toList ::: l4.toList ::: helper(matrix,left+1,right-1,top+1,bottom-1)
    }
  }
}