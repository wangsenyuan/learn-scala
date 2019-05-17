package set600.set660.p664

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "aba" should "get 2" in {
    val res = Solution.strangePrinter("aba")

    res should be(2)
  }

  "aaabbb" should "get 2" in {
    val res = Solution.strangePrinter("aaabbb")

    res should be(2)
  }
}
