package set0000.set300.set370.p372

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "2 and 10" should "get 1024" in {
    val res = Solution.superPow(2, Array(1, 0))
    res should equal(1024)
  }

  "2 and 3" should "get 8" in {
    val res = Solution.superPow(2, Array(3))
    res should equal(8)
  }

  "2147483647 and 200" should "get 1198" in {
    val res = Solution.superPow(2147483647, Array(2, 0, 0))
    res should equal(1198)
  }
}
