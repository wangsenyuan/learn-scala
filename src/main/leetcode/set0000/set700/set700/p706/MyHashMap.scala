package set0000.set700.set700.p706

import scala.collection.mutable.ListBuffer

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


object Main {

  def test1(): Unit = {
    val map = new MyHashMap()
    map.put(1, 1)
    map.put(2, 2)
    println(map.get(1))
    println(map.get(3))
    map.put(2, 1)
    println(map.get(2))
    map.remove(2)
    println(map.get(2))
  }

  def test2(): Unit = {
    val map = new MyHashMap()
    map.remove(2)
    map.put(3, 11)
    map.put(4, 13)
    map.put(15, 6)
    map.put(6, 15)
    map.put(8, 8)
    map.put(11, 0)
    println(map.get(11))
    map.put(1, 10)
    map.put(12, 14)
  }

  def main(args: Array[String]): Unit = {
    //    test1()
    test2()
  }
}
