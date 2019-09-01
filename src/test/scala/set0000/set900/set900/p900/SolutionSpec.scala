package set0000.set900.set900.p900

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val iter = new Solution.RLEIterator(Array(3, 8, 0, 9, 2, 5))
    iter.next(2) should be(8)
    iter.next(1) should be(8)
    iter.next(1) should be(5)
    iter.next(2) should be(-1)
  }
}
