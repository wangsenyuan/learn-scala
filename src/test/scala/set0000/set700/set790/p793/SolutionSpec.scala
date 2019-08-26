package set0000.set700.set790.p793

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{

  "example one" should "work" in {
    val res = Solution.preimageSizeFZF(0)
    res should be(5)
  }

  "example two" should "work" in {
    val res = Solution.preimageSizeFZF(5)
    res should be(0)
  }
}
