package set0000.set800.set830.p836

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.isRectangleOverlap(Array(-6,-10,9,2), Array(0,5,4,8))
    res should be(false)
  }
}
