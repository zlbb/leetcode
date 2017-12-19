class ListNode(var _x: Int = 0,var _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def main(args: Array[String]): Unit = {
    val head = new ListNode(1,new ListNode(2,null))
    var res = deleteDuplicates(head)

    while(res != null){
      print(res.x+" ")
      res = res.next
    }
  }
  def deleteDuplicates(head: ListNode): ListNode = {
    if(head == null || head.next == null){
      head
    } else {
      val h = new ListNode()
      var competed = h
      var prev = head
      var curr = head.next
      var dup = if(prev.x == curr.x) true else false
      while(curr.next != null){
        println(prev.x,if(curr != null) curr.x else null,dup)
        if(!dup){
          competed.next = prev
          competed = competed.next
          competed.next = null
        }
        prev = curr
        curr = curr.next
        if(curr.x == prev.x){
          dup = true
        } else {
          dup = false
        }

      }

      if(prev.x != curr.x){
        competed.next = prev
      } else {
        competed.next = curr
      }
      
    
      h.next
    }
  }
}