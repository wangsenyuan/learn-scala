package set500.set510.p518

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "get 4" in {
    val res = Solution.change(5, Array(1, 2, 5))
    res should be(4)
  }
}
