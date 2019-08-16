package set800.set850.p851

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val richer = Array(Array(1, 0), Array(2, 1), Array(3, 1), Array(3, 7), Array(4, 3), Array(5, 3), Array(6, 3))
    val quiet = Array(3, 2, 5, 4, 6, 1, 7, 0)
    val res = Solution.loudAndRich(richer, quiet)
    res should equal(Array(5, 5, 2, 5, 4, 5, 6, 7))
  }
}
