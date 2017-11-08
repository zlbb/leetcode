object Solution {
    def main(args:Array[String]):Unit = {
      println(generateMatrix(3).map(_.toList).toList)
    }
    def generateMatrix(n: Int): Array[Array[Int]] = {
        val matrix = Array.ofDim[Int](n,n)
        val indexs = genIndex(0,n-1,0,n-1)
        var i = 1
        indexs.foreach{
          case (x,y) => {
            matrix(x)(y) = i
            i += 1
          }
        }
        matrix
    }
    def genIndex(left:Int,right:Int,top:Int,bottom:Int): List[(Int,Int)] = {
      if (left == right)
        (for(i <- top to bottom) yield (i,right)).toList
      else if (top == bottom)
        (left to right+1).map{(top,_)}.toList
      else if (left > right || top > bottom)
        Nil
      else{
        val l1 = (left until right).map{(top,_)}
        val l2 = for(i <- top until bottom) yield (i,right)
        val l3 = (left+1 to right).map{(bottom,_)}.reverse
        val l4 = for(i <- bottom until top by -1) yield (i,left) 

        l1.toList ::: l2.toList ::: l3.toList ::: l4.toList ::: genIndex(left+1,right-1,top+1,bottom-1)
      }
    }
}