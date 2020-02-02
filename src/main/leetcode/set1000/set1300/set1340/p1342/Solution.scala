package set1000.set1300.set1340.p1342

import scala.collection.mutable
import scala.util.Sorting

object Solution {
  def minSetSize(arr: Array[Int]): Int = {
    val cnt = mutable.Map.empty[Int, Int].withDefaultValue(0)

    arr.foreach(num => cnt(num) += 1)

    val nums = cnt.toArray

    Sorting.quickSort(nums)(Ordering.by(_._2))

    val half = arr.length / 2
    var i = nums.length - 1
    var sum = 0

    while (i >= 0 && sum < half) {
      sum += nums(i)._2
      i -= 1
    }
    nums.length - i - 1
  }
}
