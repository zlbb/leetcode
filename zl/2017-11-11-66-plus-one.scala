object Solution {
  def main(args:Array[String]): Unit = {
    println(plusOne(Array(9,9,9)).toList)
  }
  def plusOne(digits: Array[Int]): Array[Int] = {
    val tmp = digits.toList.reverse
    val one = List(1)

    add(tmp, one, 10).reverse.toArray
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