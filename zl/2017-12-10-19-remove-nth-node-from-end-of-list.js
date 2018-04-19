function ListNode(val, next) {
  this.val = val;
  this.next = next;
}

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function (head, n) {
  var t = new ListNode(0)
  t.next = head
  var i = t, j = t
  while (n-- != 0) {
    i = i.next
  }
  while (i.next) {
    i = i.next
    j = j.next
  }
  j.next = j.next.next
  return t.next 
};

var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))))

console.log(removeNthFromEnd(head, 2))
