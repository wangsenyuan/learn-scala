package set0000.set900.set900.p901

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val spanner = new Solution.StockSpanner()
    spanner.next(100) should be(1)
    spanner.next(80) should be(1)
    spanner.next(60) should be(1)
    spanner.next(70) should be(2)
    spanner.next(60) should be(1)
    spanner.next(75) should be(4)
    spanner.next(85) should be(6)
  }
}
