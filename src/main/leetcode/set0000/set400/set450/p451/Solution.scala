package set0000.set400.set450.p451

import scala.util.Sorting

object Solution {
  def frequencySort(s: String): String = {
    val freq = s.groupBy(identity).mapValues(_.size).toArray
    Sorting.quickSort(freq)(new Ordering[(Char, Int)]() {
      override def compare(x: (Char, Int), y: (Char, Int)): Int = {
        if(x._2 < y._2) {
          1
        } else if(x._2 > y._2) {
          -1
        } else {
          0
        }
      }
    })

    val res = new StringBuilder()
    for {
      (c, v) <- freq
      _ <- 0 until v
    } {
      res.append(c)
    }

    res.toString()
  }
}
