package set400.set450.p454

import scala.util.Sorting

object Solution {
  def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
    val xs = sum(A, B)
    val ys = sum(C, D)
    Sorting.quickSort(ys)

    var res = 0
    for {
      x <- xs
    } {
      val i = binarySearch(ys.length, ys(_) > -x)
      val j = binarySearch(ys.length, ys(_) >= -x)
      res += i - j
    }
    res
  }

  private def sum(a: Array[Int], b: Array[Int]): Array[Int] = {
    for {
      x <- a
      y <- b
    } yield x + y
  }

  def fourSumCount1(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
    Sorting.quickSort(D)


    var res = 0
    for {
      i <- A.indices
      j <- B.indices
      k <- C.indices
    } {
      val sum = A(i) + B(j) + C(k)
      val u = binarySearch(D.length, l => D(l) > -sum)
      val v = binarySearch(D.length, l => D(l) >= -sum)
      res += u - v
    }
    res
  }

  private def binarySearch(n: Int, fn: Int => Boolean): Int = {
    var l = 0
    var r = n
    while (l < r) {
      val mid = (l + r) / 2
      if (fn(mid)) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    r
  }

}
