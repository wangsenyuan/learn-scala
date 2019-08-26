package set0000.set400.set460.p460

import scala.collection.mutable

class LFUCache(_capacity: Int) {

  class Node(val key: Int, var value: Int) {
    var used = 0
    var next: Node = null
    var prev: Node = null
  }

  var head = new Node(-1, -1)
  head.used = Int.MaxValue
  var tail = new Node(-2, -2)
  tail.used = Int.MinValue
  head.next = tail
  tail.prev = head

  val nodes = mutable.Map.empty[Int, Node]

  private def moveNode(node: Node): Unit = {
    var prev = node.prev
    if(prev.used <= node.used) {
      removeNode(node)
      while(node.used >= prev.used) {
        prev = prev.prev
      }

      // prev.used >= node.used
      val next = prev.next
      prev.next = node
      node.prev = prev
      node.next = next
      next.prev = node
      nodes(node.key) = node
    }
  }

  def get(key: Int): Int = {
    if (nodes.contains(key)) {
      val node = nodes(key)
      node.used += 1
      moveNode(node)
      node.value
    } else {
      -1
    }
  }

  private def insertAtEnd(node: Node): Unit = {
    val prev = tail.prev
    prev.next = node
    node.next = tail
    node.prev = prev
    tail.prev = node
    nodes(node.key) = node
  }

  private def removeNode(node: Node): Unit = {
    val prev = node.prev
    val next = node.next
    prev.next = next
    next.prev = prev
    nodes.remove(node.key)
  }

  def put(key: Int, value: Int) {
    if (nodes.contains(key)) {
      val node = nodes(key)
      node.value = value
      node.used += 1
      moveNode(node)
    } else if (nodes.size < _capacity) {
      val node = new Node(key, value);
      insertAtEnd(node)
      moveNode(node)
    } else if (nodes.size > 0) {
      // need to invalidate least recently used node
      removeNode(tail.prev)
      val node = new Node(key, value)
      insertAtEnd(node)
      moveNode(node)
    }
  }
}
