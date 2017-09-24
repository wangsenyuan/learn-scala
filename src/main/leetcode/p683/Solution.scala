package p683

import java.util

object Solution {

  def kEmptySlots(flowers: Array[Int], k: Int): Int = {

    val treeSet = new util.TreeSet[Int]()
    var found = false
    var i = 0
    while (i < flowers.size && !found) {
      val x = flowers(i)

      val a = treeSet.ceiling(x)
      val b = treeSet.floor(x)

      found = (a > 0 && a - x == k + 1) || (b > 0 && x - b == k + 1)

      treeSet.add(x)

      i += 1
    }

    if (found) {
      i
    } else {
      -1
    }
  }

  def main(args: Array[String]): Unit = {
//    println(kEmptySlots(Array(1, 3, 2), 1))
//    println(kEmptySlots(Array(1, 2, 3), 1))
    println(kEmptySlots(Array(3, 9, 2, 8, 1, 6, 10, 5, 4, 7), 1))
  }
}

