object Solution {
  def addBinary(a: String, b: String): String = {
    val left = a.split("").map(_.toInt).toList.reverse
    val right = b.split("").map(_.toInt).toList.reverse 
    add(left,right,2).reverse.mkString("")
  }
  def add(left:List[Int], right:List[Int], base: Int): List[Int] = {
    var carr = 0
    var i = 0
    var res = List[Int]()
    while(i < left.size || i < right.size || carr != 0){
      val cl = if(i < left.size) left(i) else 0
      val cr = if(i < right.size) right(i) else 0
      var curr = cl + cr + carr
      
      carr = curr / base
      curr = curr % base

      println(curr,carr)
      i += 1
      res = res :+ curr
    }
    res
  }
}