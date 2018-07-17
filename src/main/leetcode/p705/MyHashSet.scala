package p705

import scala.collection.mutable.ListBuffer

class MyHashSet() {

  /** Initialize your data structure here. */
  val map = new MyHashMap()

  def add(key: Int) {
    map.put(key, 1)
  }

  def remove(key: Int) {
    map.remove(key)
  }

  /** Returns true if this set contains the specified element */
  def contains(key: Int): Boolean = {
    map.get(key) == 1
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
    if (count * 4 > capacity * 3) {
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
