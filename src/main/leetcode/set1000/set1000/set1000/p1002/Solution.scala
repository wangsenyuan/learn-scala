package set1000.set1000.set1000.p1002

import scala.collection.mutable.ListBuffer

object Solution {
  def commonChars(A: Array[String]): List[String] = {
    val cnts = A.map(characterCount)
    val res = (0 until 26).map(x => findMin(cnts, x))
    val buf = ListBuffer.empty[String]

    for {
      i <- 0 until 26
      if res(i) > 0
    } {
      val s = ('a' + i).toChar.toString
      var c = res(i)
      while (c > 0) {
        buf += s
        c -= 1
      }
    }

    buf.toList
  }

  private def characterCount(s: String): Array[Int] = {
    val cnt = Array.ofDim[Int](26)
    s.foreach(c => cnt(c - 'a') += 1)
    cnt
  }

  private def findMin(cnts: Array[Array[Int]], num: Int): Int = {
    var res = cnts(0)(num)
    var i = 1
    while (i < cnts.length) {
      res = res min cnts(i)(num)
      i += 1
    }
    res
  }
}
