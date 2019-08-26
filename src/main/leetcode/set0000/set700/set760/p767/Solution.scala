package set0000.set700.set760.p767

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Solution {
  def reorganizeString(S: String): String = {
    val n = S.length
    val cnt = Array.ofDim[Int](26)
    S.foreach(c => cnt(c - 'a') += 1)

    val mx = cnt.max

    if(n % 2 == 1 && (mx * 2 > n + 1)) {
      ""
    } else if(n % 2 == 0 && mx * 2 > n) {
      ""
    } else {
      val psb = ArrayBuffer.empty[(Char, Int)]
      var j = 0
      while(j < 26) {
        if(cnt(j) > 0) {
          psb += ('a' + j).toChar -> cnt(j)
        }
        j += 1
      }

      val ps = psb.toArray
      Sorting.quickSort(ps)(Ordering.fromLessThan((x, y) => x._2 > y._2))
      val res = Array.ofDim[Char](n)

      var offset = 0
      j = 0
      while(offset < 2) {
        var i = offset
        while(i < n) {
          val cur  = ps(j)
          var x = cur._2
          while(i < n && x > 0) {
            res(i) = cur._1
            x -= 1
            i += 2
          }
          if(x > 0) {
            ps(j) = cur._1 -> x
            j -= 1
          }
          j += 1
        }

        offset += 1
      }

      res.mkString("")
    }

  }
}
