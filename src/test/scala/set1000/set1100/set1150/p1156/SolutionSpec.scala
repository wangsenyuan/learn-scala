package set1000.set1100.set1150.p1156

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.maxRepOpt1("aaabaaa")
    res should be(6)
  }
}
