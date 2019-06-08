package set700.set740.p743

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val times = Array(Array(3, 5, 78), Array(2, 1, 1), Array(1, 3, 0), Array(4, 3, 59), Array(5, 3, 85), Array(5, 2, 22), Array(2, 4, 23), Array(1, 4, 43), Array(4, 5, 75), Array(5, 1, 15), Array(1, 5, 91), Array(4, 1, 16), Array(3, 2, 98), Array(3, 4, 22), Array(5, 4, 31), Array(1, 2, 0), Array(2, 5, 4), Array(4, 2, 51), Array(3, 1, 36), Array(2, 3, 59))

    val N = 5
    val K = 5

    val res = Solution.networkDelayTime(times, N, K)
    res should be(31)
  }

}
