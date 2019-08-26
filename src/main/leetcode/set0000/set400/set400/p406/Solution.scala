package set0000.set400.set400.p406

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Solution {
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    val n = people.length
    val res = ArrayBuffer.empty[Array[Int]]

    Sorting.quickSort(people)(new Ordering[Array[Int]]() {
      override def compare(x: Array[Int], y: Array[Int]): Int = {
        if (x(0) > y(0)) {
          -1
        } else if (x(0) == y(0) && x(1) < y(1)) {
          -1
        } else if (x(1) == y(1) && x(0) == y(0)) {
          0
        } else {
          1
        }
      }
    })

    for (
      cur <- people
    ) {
      res.insert(cur(1), cur)
    }

    res.toArray
  }
}
