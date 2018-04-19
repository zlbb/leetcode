/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function (l1, l2) {
  var head = new ListNode(0)
  var i = head

  while (l1 || l2) {
    if (l1 && l2) {
      if (l1.val < l2.val) {
        i.next = l1
        l1 = l1.next
        i = i.next
        i.next = null
      } else {
        i.next = l2
        l2 = l2.next
        i = i.next
        i.next = null
      }
    } else if (l1) {
      i.next = l1
      l1 = l1.next
      i = i.next
      i.next = null
    } else if (l2) {
      i.next = l2
      l2 = l2.next
      i = i.next
      i.next = null
    }
  }
  return head.next
};