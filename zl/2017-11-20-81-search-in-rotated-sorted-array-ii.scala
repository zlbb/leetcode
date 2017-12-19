object Solution {
  def main(args: Array[String]):Unit = {
    println(search(Array(4,5,6,7,0,1,2),8))
  }
  def search(nums: Array[Int], target: Int): Boolean = {
    var i = 0
    var j = nums.length - 1
    while(j - i > 1){
      var mid = (i + j) / 2
      if(nums(mid) < nums(j)){
        if(nums(mid) < target && nums(j) >= target){
          i = mid + 1
        }else{
          j = mid
        }
      } else if(nums(mid) > nums(j)){
        if(nums(i) <= target && nums(mid) > target){
          j = mid - 1
        } else {
          i = mid
        }
      } else {
        j = j -1
      }
      println(i,j)
    }
    nums.length !=0 && (nums(i) == target || nums(j) == target)
  }
}