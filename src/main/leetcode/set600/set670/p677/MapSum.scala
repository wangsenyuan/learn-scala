package set600.set670.p677

import scala.collection.mutable

class MapSum() {

  /** Initialize your data structure here. */
  val root = new Node

  def insert(key: String, value: Int) {
    root.insert(key, value)
  }

  def sum(prefix: String): Int = {
    root.search(prefix)
  }

  class Node {
    var value = 0
    var sum = 0
    val children = mutable.Map.empty[Char, Node]

    def insert(key: String, value: Int): Int = {
      if(key.isEmpty) {
        this.sum -= this.value
        this.sum += value
        this.value = value
      } else {
        val h = key.head
        if(!children.contains(h)) {
          children(h) = new Node
        }
        this.sum -= children(h).sum
        children(h).insert(key.tail, value)
        this.sum += children(h).sum
      }

      this.sum
    }

    def search(key: String): Int = {
      if(key.isEmpty) {
        this.sum
      } else {
        val h = key.head
        if(!children.contains(h)) {
          0
        } else {
          children(h).search(key.tail)
        }
      }
    }
  }
}
