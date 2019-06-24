package set700.set760.p765

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val row = Array(0, 2, 1, 3)
    val res = Solution.minSwapsCouples(row)
    res should be(1)
  }

  "example two" should "work" in {
    val row = Array(3, 2, 0, 1)
    val res = Solution.minSwapsCouples(row)
    res should be(0)
  }
}
