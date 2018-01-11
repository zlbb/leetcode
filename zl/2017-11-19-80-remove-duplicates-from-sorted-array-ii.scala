object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    val dist = nums.distinct
    val res = dist.flatMap(i => if(nums.filter(_ == i).length > 1) Array(i,i) else Array(i))

    for(i <- 0 until res.length){
      nums(i)=res(i)
    }
    res.length
  }
}