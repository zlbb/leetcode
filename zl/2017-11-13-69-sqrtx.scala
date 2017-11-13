object Solution {
  def main(args:Array[String]): Unit ={
    println(mySqrt(1))
    println(mySqrt(2))
    println(mySqrt(4))
    println(mySqrt(2147395600))
    
  }
  def mySqrt(x: Int): Int = {
    var i = 1
    while(i * i.toLong <= x){
      i += 1
    } 
    i - 1
  }
}