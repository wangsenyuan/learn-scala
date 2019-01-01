package set100.set140.p146

import scala.collection.mutable

class LRUCache(_capacity: Int) {

  class Node(val key: Int, var value: Int) {
    var next: Node = null
    var prev: Node = null
  }

  val cache = mutable.Map.empty[Int, Node]

  var head: Node = new Node(-1, -1)
  var tail: Node = new Node(-2, -2)
  head.next = tail
  tail.prev = head


  private def putNodeInLastPosition(node: Node) = {
    val nodeBeforeTail = tail.prev
    nodeBeforeTail.next = node
    node.prev = nodeBeforeTail
    node.next = tail
    tail.prev = node
  }

  private def moveNodeToLastPosition(node: Node) = {
    val prev = node.prev
    val next = node.next
    prev.next = next
    next.prev = prev
    putNodeInLastPosition(node)
  }

  def get(key: Int): Int = {
    cache.get(key) match {
      case None => -1
      case Some(node) =>
        if (node.next != tail) {
          //not the last
          moveNodeToLastPosition(node)
        }
        node.value
    }
  }

  def put(key: Int, value: Int) {
    cache.get(key) match {
      case None =>
        //need to check capacity
        if (cache.size == _capacity) {
          //need to remove first one
          val first = head.next
          val next = first.next
          head.next = next
          next.prev = head
          cache.remove(first.key)
        }
        val node = new Node(key, value)
        putNodeInLastPosition(node)
        cache.put(key, node)
      case Some(node) => {
        node.value = value
        //nothing should happen except move it to last position
        moveNodeToLastPosition(node)
      }
    }
  }

}
