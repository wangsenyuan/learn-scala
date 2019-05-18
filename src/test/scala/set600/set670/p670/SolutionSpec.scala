package set600.set670.p670

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "2736" should "get 7236" in {
    val res = Solution.maximumSwap(2736)
    res should be(7236)
  }

  "9973" should "get 9973" in {
    val res = Solution.maximumSwap(9973)
    res should be(9973)
  }

  "98368" should "get 98863" in {
    val res = Solution.maximumSwap(98368)
    res should be(98863)
  }
}
