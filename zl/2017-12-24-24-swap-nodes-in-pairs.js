/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
function ListNode(val, next) {
  this.val = val;
  this.next = next;
}
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function (t) {
  head = new ListNode(0)
  head.next = t
  let i = head, j = head.next
  while (j && j.next) {

    i.next = j.next
    j.next = j.next.next
    i.next.next = j

    i = j
    j = j.next
  }

  return head.next
};

let list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))
console.log(swapPairs(list))