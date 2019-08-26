package set0000.set700.set790.p798

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(2, 3, 1, 4, 0)
    val res = Solution.bestRotation(arr)
    res should be(3)
  }
}
