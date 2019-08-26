package set0000.set000.set040.p042

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get 6 when given [0,1,0,2,1,0,1,3,2,1,2,1]" in {
    val height = Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    val res = Solution.trap(height)
    res shouldBe 6
  }
}
