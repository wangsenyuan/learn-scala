package set1000.set1000.set1070.p1078

import scala.collection.mutable.ArrayBuffer

object Solution {
  def findOcurrences(text: String, first: String, second: String): Array[String] = {
    val ss = text.split(" ")
    val res = ArrayBuffer.empty[String]
    var i = 0
    while (i + 2 < ss.length) {
      if (ss(i) == first && ss(i + 1) == second) {
        res += ss(i + 2)
      }
      i += 1
    }

    res.toArray
  }
}
