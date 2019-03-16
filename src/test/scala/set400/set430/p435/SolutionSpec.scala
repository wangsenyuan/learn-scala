package set400.set430.p435

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  private def intervals(arr: Array[Array[Int]]): Array[Solution.Interval] = {
    arr.map(x => new Solution.Interval(x(0), x(1)))
  }

  "example one" should "get 1" in {
    val res = Solution.eraseOverlapIntervals(intervals(Array(Array(1, 2), Array(2, 3), Array(3, 4), Array(1, 3))))
    res should be(1)
  }
}
