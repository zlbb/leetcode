object Solution {
    def main(args:Array[String]): Unit = {
      println(canJump(Array(2,3,1,1,4)))
      println(canJump(Array(3,2,1,0,4)))
    }
    def canJump(nums: Array[Int]): Boolean = {
      var last = nums.length-1
      for(i <- last-1 to 0 by -1) if(nums(i)+i >= last) last = i
      
      last == 0
    }
}