package set0000.set900.set910.p916

import scala.collection.mutable.ListBuffer

object Solution {
  def wordSubsets(A: Array[String], B: Array[String]): List[String] = {
    val cnt = Array.ofDim[Int](26)
    val tmp = Array.ofDim[Int](26)
    B.foreach(b => {
      (0 until 26).foreach(i => tmp(i) = 0)

      for {
        x <- b
        y = x - 'a'
      } {
        tmp(y) += 1
      }
      (0 until 26).foreach(i => cnt(i) = cnt(i) max tmp(i))
    })

    val res = ListBuffer.empty[String]

    A.foreach(a => {
      (0 until 26).foreach(i => tmp(i) = 0)

      for {
        x <- a
        y = x - 'a'
      } {
        tmp(y) += 1
      }

      val can = (0 until 26).forall(i => cnt(i) <= tmp(i))

      if (can) {
        res += a
      }
    })

    res.toList

  }
}
