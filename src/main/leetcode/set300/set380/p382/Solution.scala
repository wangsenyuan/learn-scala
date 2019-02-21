package set300.set380.p382


/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}


class Solution(_head: ListNode) {
  var i = 0

  import scala.collection.mutable

  val ii = mutable.Map.empty[Int, ListNode]

  var tmp = _head
  while (tmp != null) {
    ii += i -> tmp
    i += 1
    tmp = tmp.next
  }

  val rand = new util.Random()
  /** @param head The linked list's head.
    *             Note that the head is guaranteed to be not null, so it contains at least one node. */


  /** Returns a random node's value. */
  def getRandom(): Int = {
    val j = rand.nextInt(i)
    ii(j).x
  }

}
