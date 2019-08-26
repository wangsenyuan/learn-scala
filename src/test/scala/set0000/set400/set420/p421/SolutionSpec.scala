package set0000.set400.set420.p421

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "[3, 2]" should "get 1" in {
    val res = Solution.findMaximumXOR(Array(3, 2))
    res should be(1)
  }
}
