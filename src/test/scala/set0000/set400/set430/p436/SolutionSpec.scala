package set0000.set400.set430.p436

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  private def intervals(arr: Array[Array[Int]]): Array[Solution.Interval] = {
    arr.map(x => new Solution.Interval(x(0), x(1)))
  }

  "example one" should "work" in {
    val its = intervals(Array(Array(1, 2)))
    val res = Solution.findRightInterval(its)
    res should equal(Array(-1))
  }

  "example two" should "work" in {
    val its = intervals(Array(Array(3, 4), Array(2, 3), Array(1, 2)))
    val res = Solution.findRightInterval(its)
    res should equal(Array(-1, 0, 1))
  }

  "example three" should "work" in {
    val its = intervals(Array(Array(1, 4), Array(2, 3), Array(3, 4)))
    val res = Solution.findRightInterval(its)
    res should equal(Array(-1, 2, -1))
  }
}
