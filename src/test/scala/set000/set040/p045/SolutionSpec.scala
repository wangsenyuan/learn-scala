package set000.set040.p045

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get 2 when given [2,3,1,1,4]" in {
    val res = Solution.jump(Array(2, 3, 1, 1, 4))
    res shouldBe 2
  }
}
