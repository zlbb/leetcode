object Solution {
  def sortColors(nums: Array[Int]): Unit = {
    val sorted = nums.sortBy(i=>i)
    for(i <- 0 until nums.length){
        nums(i) = sorted(i)
    }
  }
}