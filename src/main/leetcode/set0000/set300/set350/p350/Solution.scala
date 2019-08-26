package set0000.set300.set350.p350


object Solution {
  def intersect1(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    var cnt = nums1.groupBy(identity).mapValues(_.size)
    var res = List.empty[Int]
    nums2.foreach(x => {
      if (cnt.contains(x) && cnt(x) > 0) {
        res = x :: res
        cnt += x -> (cnt(x) - 1)
      }
    })
    res.toArray
  }

  import scala.collection.mutable.ArrayBuffer
  import scala.util.Sorting

  def intersect(x: Array[Int], y: Array[Int]): Array[Int] = {
    //    val x = nums1.sorted
    //    val y = nums2.sorted
    Sorting.quickSort(x)
    Sorting.quickSort(y)
    var i = 0
    var j = 0

    val res = ArrayBuffer.empty[Int]

    //    res.sizeHint(x.length min y.length)

    while (i < x.length && j < y.length) {
      if (x(i) < y(j)) {
        i += 1
      } else if (y(j) < x(i)) {
        j += 1
      } else if (x(i) == y(j)) {
        res += x(i)
        i += 1
        j += 1
      }
    }

    //    res.result().toArray
    res.toArray
  }
}
