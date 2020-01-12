package set1000.set1300.set1320.p1320

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.minimumDistance("CAKE")
    res should be(3)
  }

  "example two" should "work" in {
    val res = Solution.minimumDistance("HAPPY")
    res should be(6)
  }

  "example three" should "work" in {
    val res = Solution.minimumDistance("NEW")
    res should be(3)
  }

  "example four" should "work" in {
    val res = Solution.minimumDistance("YEAR")
    res should be(7)
  }
}
