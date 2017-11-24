object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    if(nums.length == 0){
      List(Nil)
    }else{
      val t = subsets(nums.tail)
      t.map(_:+ nums(0)) ::: t
    }
  }
}