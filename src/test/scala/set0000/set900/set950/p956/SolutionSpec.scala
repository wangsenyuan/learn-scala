package set0000.set900.set950.p956

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val rods = Array(1, 2, 3, 6)
    Solution.tallestBillboard(rods) should be(6)
  }

  "example two" should "work" in {
    val rods = Array(1, 2, 3, 4, 5, 6)
    Solution.tallestBillboard(rods) should be(10)
  }

  "example three" should "work" in {
    val rods = Array(1, 2)
    Solution.tallestBillboard(rods) should be(0)
  }
}
