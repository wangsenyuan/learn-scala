package set0000.set800.set800.p809

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.expressiveWords("heeellooo", Array("hello", "hi", "helo"))
    res should be(1)
  }
}
