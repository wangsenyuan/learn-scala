package set600.set640.p646

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val pairs = Array(Array(9,10), Array(9,10), Array(4,5), Array(-9,-3), Array(-9,1), Array(0,3), Array(6,10), Array(-5,-4), Array(-7,-6))
    val res = Solution.findLongestChain(pairs)

    res should be(5)
  }
}
