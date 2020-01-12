package set1000.set1300.set1310.p1318

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.minFlips(8, 3, 5)
    res should be(3)
  }
}
