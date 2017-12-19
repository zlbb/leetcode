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
    val head = new ListNode(1,new ListNode(1,new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(5)))))))
    deleteDuplicates(head)
  }
  def deleteDuplicates(head: ListNode): ListNode = {
    if(head == null){
      head
    } else {
      val h = new ListNode()
      var competed = h
      
      var prev = head
      var curr = head.next

      var dup = false
      while(curr != null){
        if(curr.x == prev.x){
          dup = true
          println(prev.x,if(curr != null) curr.x else null,dup)
        } else {
          println(prev.x,if(curr != null) curr.x else null,dup)
          if(!dup){
            competed.next = prev
            competed = competed.next
            competed.next = null
          } else {
          }
          dup = false
        }
        prev = curr
        curr = curr.next
      }

      if(!dup){
        competed.next = prev
      }
    
      h.next
    }
  }
}