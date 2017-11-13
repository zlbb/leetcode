
object Solution {
    def main(args: Array[String]): Unit = {
      val res = maxSubArray(Array(-1,-2))
      println(res)
    }
    def maxSubArray(nums: Array[Int]): Int = {
      if(nums.length == 1){
        nums(0)
      } else {
        val sums:List[Int] = nums.tails.map{_.sum}.toList.reverse.tail.reverse
        val (max,maxI) = sums.zipWithIndex.maxBy(_._1)
        val (min,minI) = sums.zipWithIndex.minBy(_._1)

        println(sums)

        sums.find(_ > 0) match {
          case _ => {
            val tailMin = sums.slice(maxI,sums.size).min
            val headMax = sums.slice(0,minI+1).max 
            println(min,minI,max,maxI,tailMin,headMax)
            Math.max(max - tailMin, headMax - min)
          }
        }

      }
    }
}
