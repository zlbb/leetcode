/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function (lists) {
  let head = new ListNode()
  head.next = null
  t = head

  while (true) {
    let i = findAndShiftMin(lists)
    if (!i) break
    t.next = i
    t = t.next
  }

  return head.next
};

function findAndShiftMin(lists) {
  if (lists.length == 0) {
    return null
  }
  let minIdx = -1
  for (let i in lists) {
    if (minIdx == -1) {
      if (lists[i]) {
        minIdx = i
      }
      continue
    }
    if (lists[i] && lists[i].val < lists[minIdx].val) {
      minIdx = i
    }
  }
  if (minIdx == -1) return null
  let t = lists[minIdx]
  lists[minIdx] = lists[minIdx].next
  t.next = null
  return t
}