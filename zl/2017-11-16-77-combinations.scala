object Solution {
  def main(args:Array[String]):Unit = {
    println(combine(4,2))
  }
  def combine(n: Int, k: Int): List[List[Int]] = {
    if(k==1){
      1 to n map{List(_)} toList
    }else{
      var res = List[List[Int]]()
      for(i <- k to n){
        res = res ::: combine(i-1,k-1).map(_:+i)
      }
      res
    }
  }
}