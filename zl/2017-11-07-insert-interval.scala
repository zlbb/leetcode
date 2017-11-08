/**
 * Definition for an interval.
 * class Interval(var _start: Int = 0, var _end: Int = 0) {
 *   var start: Int = _start
 *   var end: Int = _end
 * }
 */
class Interval(var _start: Int = 0, var _end: Int = 0) {
  var start: Int = _start
  var end: Int = _end
}
object Solution {
    def insert(intervals: List[Interval], newInterval: Interval): List[Interval] = {
      merge((newInterval :: intervals).sortBy(_.start))
    }
    def merge(intervals: List[Interval]): List[Interval] = {
      if (intervals.length == 0){
       intervals 
      }else{
        val sorted = intervals 
        var stack = sorted.head :: Nil

        for(i <- 1 until sorted.length) {
          val curr = stack.head
          if(sorted(i).start <= curr.end){
            curr.end = Math.max(sorted(i).end,curr.end)
          } else {
            stack = sorted(i) :: stack 
          }
        }
        stack.reverse
      }
    }
}