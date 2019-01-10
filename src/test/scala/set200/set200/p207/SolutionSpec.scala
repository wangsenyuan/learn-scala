package set200.set200.p207

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "get true" in {
    val n = 2
    val pre = Array(Array(1, 0))
    val res = Solution.canFinish(n, pre)
    res should be(true)
  }

  "example two" should "get false" in {
    val n = 2
    val pre = Array(Array(1, 0), Array(0, 1))
    val res = Solution.canFinish(n, pre)
    res should be(false)
  }

  "example three" should "get false" in {
    val n = 3
    val pre = Array(Array(1, 0), Array(1, 2), Array(0, 1))
    val res = Solution.canFinish(n, pre)
    res should be(false)
  }
}
