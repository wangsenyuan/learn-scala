package set1000.set1300.set1310.p1316

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.distinctEchoSubstrings("abcabcabc")
    res should be(3)
  }

  "example two" should "work" in {
    val res = Solution.distinctEchoSubstrings("aaaaaaaaaa")
    res should be(5)
  }
}
