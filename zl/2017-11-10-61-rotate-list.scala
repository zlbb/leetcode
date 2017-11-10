/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
  override def toString() = x + (if(next != null) " -> " + next.toString else "")
}
object Solution {
  def main(args:Array[String]): Unit = {
    val head = new ListNode(1)
    head.next = new ListNode(2)
    
    println(head)
    println(rotateRight(head,2))
  }
  def rotateRight(head: ListNode, k: Int): ListNode = {
    var curr = head
    var tail = head
    var oCurr:ListNode = null 
    var n = 1;
    if(k==0){
      head
    } else if(head == null){
      head
    }else{
      while(tail.next != null){
        tail = tail.next 
        n += 1
      }
      if(k  % n == 0){
        head
      }else{
        val ck =k  % n
        for(i <- 1 to (n-ck)){
          oCurr = curr
          curr = curr.next
        }
        if(oCurr == null)(
          head
        )else{
          oCurr.next = null 
          tail.next = head
          curr
        }
      }
    }
  }
}