package set0000.set000.set090.p090

import scala.collection.mutable.ListBuffer

object Solution {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    subsets(nums.sorted)
  }

  private def subsets(nums: Array[Int]): List[List[Int]] = {
    val n = nums.length
    var j = 0
    var i = 1

    var res: List[List[Int]] = List(Nil)
    while (i <= n) {
      if (i == n || nums(i) > nums(i - 1)) {
        val ss = pow(nums(i - 1), i - j)

        res = join(res, ss)

        j = i
      }
      i += 1
    }

    res
  }

  private def pow(num: Int, cnt: Int): List[List[Int]] = {
    val res = ListBuffer.empty[List[Int]]
    res += Nil
    var i = 1
    while (i <= cnt) {
      val last = res.last
      res += num :: last
      i += 1
    }
    res.toList
  }

  private def join(a: List[List[Int]], b: List[List[Int]]): List[List[Int]] = {
    a.flatMap(x => b.map(y => x ++ y))
  }
}
