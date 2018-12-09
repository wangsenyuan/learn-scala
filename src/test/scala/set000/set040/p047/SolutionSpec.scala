package set000.set040.p047

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get [1,1,2],\n  [1,2,1],\n  [2,1,1] when given [1, 1, 2]" in {
    val res = Solution.permuteUnique(Array(1, 1, 2))
    res shouldEqual List(List(1, 1, 2), List(1, 2, 1), List(2, 1, 1))
  }

  it should "get 6 elements list when given [2,2,1,1]" in {
    val res = Solution.permuteUnique(Array(2, 2, 1, 1))
    res.size shouldBe (6)
  }
}
