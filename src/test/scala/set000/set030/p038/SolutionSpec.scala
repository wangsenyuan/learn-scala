package set000.set030.p038

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get 1211 when countAndSay 4" in {
    val res = Solution.countAndSay(4)
    res shouldEqual "1211"
  }

  it should "get 111221 when countAndSay 5" in {
    val res = Solution.countAndSay(5)
    res shouldEqual "111221"
  }
}
