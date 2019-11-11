package set1000.set1000.set1090.p1090

import scala.collection.mutable
import scala.util.Sorting

object Solution {
  def largestValsFromLabels(values: Array[Int], labels: Array[Int], num_wanted: Int, use_limit: Int): Int = {
    val items = values.zip(labels)
    Sorting.quickSort(items)(Ordering.by(_._1))

    var res = 0
    var i = items.length - 1

    val cnt = mutable.Map.empty[Int, Int].withDefaultValue(0)
    var x = num_wanted
    while (i >= 0 && x > 0) {
      val item = items(i)
      if (cnt(item._2) < use_limit) {
        res += item._1
        cnt(item._2) += 1
        x -= 1
      }
      i -= 1
    }

    res
  }
}
