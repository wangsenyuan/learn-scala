package set700.set700.p705

import scala.collection.mutable.ListBuffer

class MyHashSet() {

  /** Initialize your data structure here. */
  val map = new HashTable()

  def add(key: Int) {
    map.add(key)
  }

  def remove(key: Int) {
    map.remove(key)
  }

  /** Returns true if this set contains the specified element */
  def contains(key: Int): Boolean = {
    map.contains(key)
  }

}

class HashTable() {
  var capacity = 4096
  var count = 0
  class Node(val value: Int) {
    var next: Node = null
  }

  var table = Array.ofDim[Node](capacity)

  private def hash(key: Int) = key & (capacity - 1)

  private def addIntoTable(key: Int, table: Array[Node]): Boolean = {
    val h = hash(key)
    if(table(h) == null) {
      table(h) = new Node(key)
      true
    } else {
      var prev: Node = null
      var head = table(h)
      while(head != null && key > head.value) {
        prev = head
        head = head.next
      }
      if(head == null) {
        // the last
        prev.next = new Node(key)
        true
      } else if(head.value == key) {
        // exists there
        false
      } else {
        // head.value > key
        val node = new Node(key)
        node.next = head
        if(prev == null) {
          table(h) = node
        } else {
          prev.next = node
        }
        true
      }
    }
  }

  private def rehash(): Unit = {
    capacity <<= 1

    val back = Array.ofDim[Node](capacity)
    var i = 0
    while(i < capacity / 2) {
      if(table(i) != null) {
        var node = table(i)
        while(node != null) {
          addIntoTable(node.value, back)
          node = node.next
        }
      }
      i += 1
    }

    table = back
  }

  def add(key: Int): Unit = {
    val res = addIntoTable(key, table)
    if(res) {
      count += 1
      if(count * 4 > capacity * 3) {
        rehash()
      }
    }
  }

  def contains(key: Int): Boolean = {
    val h = hash(key)
    var node = table(h)
    while(node != null && node.value < key) {
      node = node.next
    }
    node != null && node.value == key
  }

  def remove(key: Int): Boolean = {
    val h = hash(key)
    var prev: Node = null
    var node = table(h)
    while(node != null && node.value < key) {
      prev = node
      node = node.next
    }

    if(node != null && node.value == key) {
      val next = node.next
      if(prev == null) {
        table(h) = next
      } else {
        prev.next = next
      }
      count -= 1
      true
    } else {
      false
    }
  }
}

class MyHashMap() {

  /** Initialize your data structure here. */

  var capacity = 8

  var table = Array.fill(capacity)(ListBuffer.empty[(Int, Int)])

  val loadFactor = 0.75
  var count = 0

  private def hashKey(key: Int) = key & (capacity - 1)

  private def putIntoTable(table: Array[ListBuffer[(Int, Int)]], key: Int, value: Int): Unit = {
    val hash = hashKey(key)
    if (table(hash).isEmpty) {
      count += 1
      table(hash) += (key -> value)
    } else {
      var i = 0
      while (i < table(hash).size && table(hash)(i)._1 != key) {
        i += 1
      }
      if (i == table(hash).size) {
        table(hash) += (key -> value)
      } else {
        // override
        table(hash)(i) = key -> value
      }
    }
  }

  private def rehash(): Unit = {
    capacity <<= 1

    val back = Array.fill(capacity)(ListBuffer.empty[(Int, Int)])

    for {
      row <- table
      (key, value) <- row
    } {
      putIntoTable(back, key, value)
    }
    table = back
  }


  /** value will always be non-negative. */
  def put(key: Int, value: Int) {
    putIntoTable(table, key, value)
    if (count * 4 * 4 > capacity * 3) {
      rehash()
    }
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  def get(key: Int): Int = {
    val hash = hashKey(key)
    if (table(hash).isEmpty) {
      -1
    } else {
      var i = 0
      while (i < table(hash).size && table(hash)(i)._1 != key) {
        i += 1
      }
      if (i == table(hash).size) {
        -1
      } else {
        table(hash)(i)._2
      }
    }
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  def remove(key: Int) {
    val hash = hashKey(key)
    if (table(hash).size > 0) {
      var i = 0
      while (i < table(hash).size && table(hash)(i)._1 != key) {
        i += 1
      }
      if (i < table(hash).size) {
        table(hash).remove(i)
      }
    }
  }

}
