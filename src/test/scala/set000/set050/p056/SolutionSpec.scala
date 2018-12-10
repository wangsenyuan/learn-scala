package set000.set050.p056

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  private def newInterval(a: Int, b: Int) = new Interval(a, b)

  "merge [[1,3],[2,6],[8,10],[15,18]]" should "get [[1,6],[8,10],[15,18]]" in {
    val intervals = List(newInterval(1, 3), newInterval(2, 6), newInterval(8, 10), newInterval(15, 18))
    val res = Solution.merge(intervals)
    res.size should be(3)
    val first = res.head
    first.start should be(1)
    first.end should be(6)
  }
}
