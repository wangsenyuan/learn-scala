package set0000.set400.set460.p466

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "get 2" in {
    val res = Solution.getMaxRepetitions("acb", 4, "ab", 2)
    res should be(2)
  }

  "example two" should "get 4" in {
    val res = Solution.getMaxRepetitions("aaa", 3, "aa", 1)
    res should be(4)
  }

  "example three" should "get 12" in {
    val res = Solution.getMaxRepetitions("aaa", 20, "aaaaa", 1)
    res should be(12)
  }
}
