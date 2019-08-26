package set0000.set400.set430.p432

import scala.collection.mutable

class AllOne() {

  class Node(val key: String, var count: Int) {
    var next: Node = null
    var prev: Node = null
  }

  val head = new Node("", 0)
  val tail = new Node("", Int.MaxValue)
  head.next = tail
  tail.prev = head

  val nodes = mutable.Map.empty[String, Node]

  /** Initialize your data structure here. */


  /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
  def inc(key: String) {
    if(nodes.contains(key)) {
      val node = nodes(key)
      node.count += 1
      if(node.count > node.next.count) {
        // need to move
        var prev = node.prev
        var next = node.next
        prev.next = next
        next.prev = prev


        while(node.count > next.count) {
          next = next.next
        }

        prev = next.prev
        prev.next = node
        node.prev = prev
        node.next = next
        next.prev = node
      }
    } else {
      // insert it
      val node = new Node(key, 1)
      nodes.put(key, node)
      val next = head.next
      head.next = node
      node.prev = head
      next.prev = node
      node.next = next
    }
  }

  /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
  def dec(key: String) {
    if(nodes.contains(key)) {
      val node = nodes(key)
      node.count -= 1
      var prev = node.prev
      var next = node.next
      if(node.count == 0) {
        prev.next = next
        next.prev = prev
        nodes -= key
      } else if(prev.count > node.count) {
        // need to move
        prev.next = next
        next.prev = prev
        while(prev.count > node.count) {
          prev = prev.prev
        }
        next = prev.next
        prev.next = node
        node.prev = prev
        node.next = next
        next.prev = node
      }
    }
  }

  /** Returns one of the keys with maximal value. */
  def getMaxKey(): String = {
    if(nodes.isEmpty) {
      ""
    } else {
      tail.prev.key
    }
  }

  /** Returns one of the keys with Minimal value. */
  def getMinKey(): String = {
    if(nodes.isEmpty) {
      ""
    } else {
      head.next.key
    }
  }

}

/**
  * Your AllOne object will be instantiated and called as such:
  * var obj = new AllOne()
  * obj.inc(key)
  * obj.dec(key)
  * var param_3 = obj.getMaxKey()
  * var param_4 = obj.getMinKey()
  */
