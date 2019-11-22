package set1000.set1100.set1140.p1144

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.movesToMakeZigzag(Array(10, 4, 4, 10, 10, 6, 2, 3))
    res should be(13)
  }
}
