package set1000.set1000.set1050.p1054

import scala.collection.mutable
import scala.util.Sorting

object Solution {
  def rearrangeBarcodes(barcodes: Array[Int]): Array[Int] = {
    val mem = mutable.Map.empty[Int, Int].withDefaultValue(0)

    for {
      code <- barcodes
    } {
      mem(code) += 1
    }

    val items = Array.ofDim[Item](mem.size)
    var i = 0
    for {
      (k, c) <- mem
    } {
      items(i) = Item(k, c)
      i += 1
    }

    Sorting.quickSort(items)(Ordering.by(_.cnt))
    val n = barcodes.length

    val res = Array.ofDim[Int](n)
    var j = items.length - 1

    i = 0
    while (j >= 0) {
      val cur = items(j)

      var k = cur.cnt

      while (k > 0 && i < n) {
        res(i) = cur.code
        k -= 1
        i += 2
      }

      if (k > 0) {
        items(j) = cur.copy(cnt = k)
        i = 1
      } else {
        j -= 1
      }
    }
    res
  }

  case class Item(code: Int, cnt: Int)

}
