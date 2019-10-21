package set1000.set1200.set1230.p1235

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val start = Array(1, 2, 3, 4, 6)
    val end = Array(3, 5, 10, 6, 9)
    val profit = Array(20, 20, 100, 70, 60)
    val res = Solution.jobScheduling(start, end, profit)
    res should equal(150)
  }

  "example two" should "work" in {
    val start = Array(4, 2, 4, 8, 2)
    val end = Array(5, 5, 5, 10, 8)
    val profit = Array(1, 2, 8, 10, 4)
    val res = Solution.jobScheduling(start, end, profit)
    res should equal(18)
  }
}
