object Solution {
  def main(args:Array[String]):Unit = {
    println(getPermutation(3,6))
  }
  def fact(i:Int):Int = if(i <= 1) 1 else i * fact(i-1)
  val facts = (0 to 10 map{i=>fact(i)}).toArray 

  def getPermutation(n: Int, k: Int): String = {

    var rem = k - 1 
    val res = (1 to n).toArray
    for(i <- n-1 to 1 by -1){
      val j = rem / facts(i)
      rem = rem % facts(i)
      val base = n-i-1
      val idx = base + j
      val value = res(idx)
      println(i,j,idx,value)
      for(t <- idx-1 to base by -1){
        res(t+1) = res(t)
      }
      res(base) = value
      println(res.toList)
    } 
    res.mkString("")
  }
}