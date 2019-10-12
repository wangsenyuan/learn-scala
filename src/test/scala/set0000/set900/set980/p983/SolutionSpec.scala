package set0000.set900.set980.p983

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val days = Array(1, 4, 6, 7, 8, 20)
    val costs = Array(2, 7, 15)
    val res = Solution.mincostTickets(days, costs)
    res should be(11)
  }

  "example two" should "work" in {
    val days = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31)
    val costs = Array(2, 7, 15)
    val res = Solution.mincostTickets(days, costs)
    res should be(17)
  }
}
