package set0000.set000.set010.p011

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get 49 from [1,8,6,2,5,4,8,3,7]" in {
    val res = Solution.maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7))
    res shouldBe 49
  }

  it should "get 1 from [1,2,1]" in {
    val res = Solution.maxArea(Array(1, 2, 1))
    res shouldBe 2
  }
}
