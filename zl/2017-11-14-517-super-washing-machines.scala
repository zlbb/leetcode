object Solution {
    def findMinMoves(machines: Array[Int]): Int = {
      val sum = machines.sum
      val to = sum / machines.length 
      val remain = sum % machines.length

      if(remain != 0){
        -1
      } else {
        val load = machines.map(_ - to)
        Math.max(load.max, (0 /: load){(max,i)=>Math.max(max,Math.abs(i))})
      }
    }
}